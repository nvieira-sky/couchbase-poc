package com.example.couchbasepoc.service

import com.example.couchbasepoc.model.Service
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.couchbase.core.CouchbaseTemplate

@org.springframework.stereotype.Service
@Qualifier("ServiceTemplateService")
class ServiceTemplateService(
    private val couchbaseTemplate: CouchbaseTemplate
) : ServiceService {
    override fun create(service: Service) {
        couchbaseTemplate.insertById(Service::class.java).inCollection("services").one(service)
    }

    override fun findAll(): List<Service> {
        return couchbaseTemplate.findByQuery(Service::class.java).inCollection("services").all()
    }
}