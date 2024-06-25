package com.example.couchbasepoc.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.couchbase.core.mapping.Document
import org.springframework.data.couchbase.core.mapping.Field

@Document
data class Service(
    @Id
    @JsonProperty("id") // This is required for deserializing to a data class
    val id: String,
    @Field
    @JsonProperty("name")
    val name: String,
)
