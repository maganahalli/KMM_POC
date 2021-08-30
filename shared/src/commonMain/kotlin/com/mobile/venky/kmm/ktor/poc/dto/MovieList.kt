package com.mobile.venky.kmm.ktor.poc.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author Venky Maganahalli updated on 08/29/2021
 */
@Serializable
data class MovieList(
    @SerialName("results")
    val entries: List<SharedMovie>
)
