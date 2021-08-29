package com.mobile.venky.kmm.ktor.poc


import com.mobile.venky.kmm.ktor.poc.dto.RootMovieResponse
import com.mobile.venky.kmm.ktor.poc.dto.SharedMovie

interface Service {
    suspend fun getPopularMovies(): RootMovieResponse
    fun getMovieList(success: (List<SharedMovie>) -> Unit, failure: (Throwable?) -> Unit)
    fun getImage(url: String, success: (Image?) -> Unit, failure: (Throwable?) -> Unit)
}