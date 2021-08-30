package com.mobile.venky.kmm.ktor.poc


/**
 * @author Venky Maganahalli updated on 08/29/2021
 */

expect class Image

expect fun ByteArray.toSharedImage(): Image?