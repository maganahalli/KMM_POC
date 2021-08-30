package com.mobile.venky.kmm.ktor.poc


import com.mobile.venky.kmm.ktor.poc.dto.MovieList
import com.mobile.venky.kmm.ktor.poc.dto.RootMovieResponse
import com.mobile.venky.kmm.ktor.poc.dto.RootResponse
import com.mobile.venky.kmm.ktor.poc.dto.SharedMovie
import io.ktor.client.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
/**
 * @author Venky Maganahalli updated on 08/29/2021
 */

class WebServiceCallWithGet : Service {

    suspend fun getMovies(url: String = EndPoints().MOVIE_URL) : RootMovieResponse{
        return try {
             withContext(Dispatchers.Default){
                 getNetworkClient().get(url) as RootMovieResponse
             }

        } catch (e:Exception){
            RootMovieResponse(0,arrayListOf(),0,0).apply {
                errorMessage = " Sevice Failure : ${e.message}"
                responseStatus ="ERROR"
            }
        }
    }

    suspend fun getUsers(url: String = EndPoints().USERS_URL) : RootResponse {
        return try {
            withContext(Dispatchers.Default){
                getNetworkClient().get(url) as RootResponse
            }

        } catch (e:Exception){
            RootResponse(1,15, arrayListOf()).apply {
                responseStatus = " Sevice Failure : ${e.message}"
                responseStatus ="ERROR"
            }
        }
    }

    override suspend fun getPopularMovies(): RootMovieResponse {
         return  getMovies(EndPoints().MOVIE_URL)
    }

    override fun getMovieList(success: (List<SharedMovie>) -> Unit, failure: (Throwable?) -> Unit)  {
        GlobalScope.launch(ApplicationDispatcher) {
            try {
                val json = getNetworkClient().get<String>(EndPoints().MOVIE_URL)
                getConfiguredJson().decodeFromString(MovieList.serializer(),json)
                    .entries
                    .onEach {
                        with(Logger) { DEFAULT.log("Decoding :${it.title}") }
                    }
                    .also(success)
            } catch (ex: Exception) {
                with(Logger) { DEFAULT.log("Error in Decoding  :${ex.message}") }
                failure(ex)
            }
        }

    }


    override fun getImage(url: String, success: (Image?) -> Unit, failure: (Throwable?) -> Unit) {
        GlobalScope.launch(ApplicationDispatcher) {
            try {
                HttpClient().get<ByteArray>(url)
                    .toSharedImage()
                    .also(success)
            } catch (ex: Exception) {
                failure(ex)
            }
        }
    }
}