package com.example.couchbasepoc.service

import com.example.couchbasepoc.model.Service

interface ServiceService {
    fun create(service: Service)
    fun findAll(): List<Service>
    fun findByName(name: String): Service?
    fun findByLineupId(lineupId: String): List<Service>
}