package com.example.couchbasepoc.service

import com.example.couchbasepoc.model.Service
import com.example.couchbasepoc.repositories.ServiceRepository
import org.springframework.beans.factory.annotation.Qualifier

@org.springframework.stereotype.Service
@Qualifier("ServiceRepositoryService")
class ServiceRepositoryService(
    private val serviceRepository: ServiceRepository,
) : ServiceService {
    override fun create(service: Service) {
        serviceRepository.save(service)
    }

    override fun findAll(): List<Service> {
        return serviceRepository.findAll().toList()
    }
}