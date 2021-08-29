package com.mobile.venky.kmm.ktor.poc.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieList(
    @SerialName("results")
    val entries: List<SharedMovie>
)
