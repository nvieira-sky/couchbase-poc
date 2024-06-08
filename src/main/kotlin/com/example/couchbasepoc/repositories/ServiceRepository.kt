package com.example.couchbasepoc.repositories

import com.example.couchbasepoc.model.Service
import org.springframework.data.couchbase.repository.Collection
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Collection(value = "services")
interface ServiceRepository : CrudRepository<Service, UUID> {
    fun findByName(name: String): Service?
}