package com.example.couchbasepoc.model

import org.springframework.data.annotation.Id
import org.springframework.data.couchbase.core.mapping.Document
import org.springframework.data.couchbase.core.mapping.Field
import java.util.UUID

@Document
data class Service(
    @Id val id: UUID,
    @Field val name: String,
)
