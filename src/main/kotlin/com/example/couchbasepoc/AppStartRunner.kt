package com.example.couchbasepoc

import com.example.couchbasepoc.model.Service
import com.example.couchbasepoc.service.ServiceService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.time.Instant
import java.util.*

@Component
class AppStartRunner(
    @Qualifier("ServiceRepositoryService") private val serviceService: ServiceService
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        println("Running app start runner code")
        val service = Service(
            id = UUID.randomUUID(),
            name = "${Instant.now()} Channel"
        )
        serviceService.create(service)

        serviceService.findAll().forEach { println(it) }
    }
}