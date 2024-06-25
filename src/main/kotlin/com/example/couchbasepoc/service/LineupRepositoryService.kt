package com.example.couchbasepoc.service

import com.example.couchbasepoc.model.Lineup
import com.example.couchbasepoc.repositories.LineupRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
@Qualifier("LineupRepositoryService")
class LineupRepositoryService(
    private val lineupRepository: LineupRepository,
) : LineupService {
    override fun create(lineup: Lineup) {
        lineupRepository.save(lineup)
    }

    override fun findAll(): List<Lineup> {
        return lineupRepository.findAll().toList()
    }
}