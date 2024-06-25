package com.example.couchbasepoc.repositories

import com.example.couchbasepoc.model.Lineup
import org.springframework.data.couchbase.repository.Collection
import org.springframework.data.repository.CrudRepository
import java.util.UUID

@Collection(value = "lineups")
interface LineupRepository : CrudRepository<Lineup, UUID>