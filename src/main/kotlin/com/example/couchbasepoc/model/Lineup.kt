package com.example.couchbasepoc.model

import org.springframework.data.annotation.Id
import org.springframework.data.couchbase.core.mapping.Document
import java.util.UUID

@Document
data class Lineup(
    @Id val id: UUID,
    val channels: List<LineupChannel>
) {
    data class LineupChannel(
        val channelId: UUID
    )
}