package com.cjmobileapps.flywayr2dbcsample.data.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant
import java.util.*

data class Player constructor(
    @JsonProperty("id") var id: UUID? = null,
    @JsonProperty("firstName") val firstName: String,
    @JsonProperty("lastName") val lastName: String,
    @JsonProperty("dateCreated") val dateCreated: Instant? = null
)
