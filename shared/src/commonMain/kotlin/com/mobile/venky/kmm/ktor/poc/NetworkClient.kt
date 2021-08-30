package com.mobile.venky.kmm.ktor.poc

import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

/**
 * @author Venky Maganahalli updated on 08/29/2021
 */

// this log code only to log http in both ios and android
private fun createHttpClient(): HttpClient {

    return httpClient {

        // Json
        install(JsonFeature) {
            serializer = KotlinxSerializer(json)
        }

        // Logging
        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag = "HTTP Client", message = message)
                } } }

       // Apply for all requests
        defaultRequest {
            if(this.method != HttpMethod.Get){
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }

    }.also { initLogger() }
}

private val json = Json {
    ignoreUnknownKeys = true
    isLenient = true
    encodeDefaults = true
    prettyPrint = true
    coerceInputValues = true
}

fun getNetworkClient(): HttpClient {
    return createHttpClient()
}

fun getConfiguredJson(): Json {
    return json
}

