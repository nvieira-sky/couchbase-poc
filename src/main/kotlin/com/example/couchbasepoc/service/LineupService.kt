package com.example.couchbasepoc.service

import com.example.couchbasepoc.model.Lineup

interface LineupService {
    fun create(lineup: Lineup)
    fun findAll(): List<Lineup>
}