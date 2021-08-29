package com.mobile.venky.kmm.ktor.poc.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class RootMovieResponse(
    @SerialName("page") val page : Int,
    @SerialName("results") val results : List<SharedMovie>,
    @SerialName("total_pages") val total_pages : Int,
    @SerialName("total_results") val total_results : Int,
) : BaseResponse()

@Serializable
data class SharedMovie(
    @SerialName("adult") val adult: Boolean,
    @SerialName("backdrop_path") val backdrop_path: String?,
    @SerialName("genre_ids") val genre_ids: List<Int>,
    @SerialName("id") val id: Int,
    @SerialName("original_language") val original_language: String,
    @SerialName("original_title") val original_title: String,
    @SerialName("overview") val overview: String,
    @SerialName("popularity") val popularity: Double,
    @SerialName("poster_path") val poster_path: String,
    @SerialName("release_date") val release_date: String,
    @SerialName("title") val title: String

) {
    companion object {
        val testResultData = SharedMovie(
            adult = false,
            backdrop_path = null,
            genre_ids = arrayListOf(),
            id = 12,
            original_language = "Hindi",
            original_title =" No Title",
            overview = "Overview of the movie",
            popularity = 0.5,
            poster_path = "",
            release_date = "12-10-2012",
            title = "Why wait longer???"
        )
    }
}
