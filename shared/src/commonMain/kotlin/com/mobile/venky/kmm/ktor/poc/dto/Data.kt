package com.mobile.venky.kmm.ktor.poc.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author Venky Maganahalli updated on 08/29/2021
 */
@Serializable
data class Data(
    val id: Int,
    val email: String,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val lastName: String,
    val avatar: String
)