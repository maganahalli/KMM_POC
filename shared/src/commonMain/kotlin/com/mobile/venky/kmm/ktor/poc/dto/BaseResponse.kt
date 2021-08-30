package com.mobile.venky.kmm.ktor.poc.dto

import kotlinx.serialization.Serializable
/**
 * @author Venky Maganahalli updated on 08/29/2021
 */

@Serializable
open class BaseResponse {
    var responseStatus : String = ""
    var errorMessage : String = ""
}