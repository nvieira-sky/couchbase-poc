package com.example.couchbasepoc

import com.example.couchbasepoc.model.Lineup
import com.example.couchbasepoc.model.Service
import com.example.couchbasepoc.service.LineupService
import com.example.couchbasepoc.service.ServiceService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.time.Instant
import java.util.*

@Component
class AppStartRunner(
    @Qualifier("ServiceTemplateService") private val serviceService: ServiceService,
    @Qualifier("LineupRepositoryService") private val lineupService: LineupService
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        println("Running app start runner code")
        val service1 = Service(
            id = UUID.randomUUID().toString(),
            name = "${Instant.now()} Channel"
        )
        serviceService.create(service1)
        val service2 = Service(
            id = UUID.randomUUID().toString(),
            name = "${Instant.now()} Channel"
        )
        serviceService.create(service2)

        serviceService.findAll().forEach { println(it) }
        serviceService.findByName(service1.name).also { println(it) }

        val lineup = Lineup(
            id = UUID.randomUUID(),
            channels = listOf(
                Lineup.LineupChannel(UUID.fromString(service1.id)),
                Lineup.LineupChannel(UUID.fromString(service2.id)),
            )
        )
        lineupService.create(lineup)

        lineupService.findAll().forEach { println(it) }

        serviceService.findByLineupId(lineup.id.toString()).also { println(it) }
    }
}