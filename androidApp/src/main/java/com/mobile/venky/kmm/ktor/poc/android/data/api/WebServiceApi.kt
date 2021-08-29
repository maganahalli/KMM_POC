package com.mobile.venky.kmm.ktor.poc.android.data.api

import com.mobile.venky.kmm.ktor.poc.Service
import com.mobile.venky.kmm.ktor.poc.dto.RootMovieResponse
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Venky Maganahalli updated on 08/29/2021
 */

@Singleton
class WebServiceApi @Inject constructor(private val service : Service){

    suspend fun getPopularMovies(): RootMovieResponse {
        return service.getPopularMovies()
    }

}