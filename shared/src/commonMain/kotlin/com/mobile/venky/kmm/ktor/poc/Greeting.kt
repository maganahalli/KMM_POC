package com.mobile.venky.kmm.ktor.poc

import com.mobile.venky.kmm.ktor.poc.dto.Hello
import io.github.aakira.napier.Napier
import io.ktor.client.features.*

import kotlinx.serialization.Serializable
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class Greeting{

    suspend fun greeting(): String {
        val responseStr = getMovies().toString()
        return " ${responseStr} ${Platform().platform}!"
    }


    private suspend fun getHello(): List<Hello> {
        return getNetworkClient().get(EndPoints().KTOR_TUTORIAL_URL)
    }

    private suspend fun getUsers(): String {
        return getNetworkClient().get(EndPoints().USERS_URL)

    }

    private suspend fun getMovies(): String {
        return getNetworkClient().get(EndPoints().MOVIE_URL)

    }


}