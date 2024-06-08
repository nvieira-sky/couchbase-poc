package com.example.couchbasepoc.service

import com.example.couchbasepoc.model.Service

interface ServiceService {
    fun create(service: Service)
    fun findAll(): List<Service>
}