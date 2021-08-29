package com.mobile.venky.kmm.ktor.poc.dto

import kotlinx.serialization.Serializable

@Serializable
open class BaseResponse {
    var responseStatus : String = ""
    var errorMessage : String = ""
}