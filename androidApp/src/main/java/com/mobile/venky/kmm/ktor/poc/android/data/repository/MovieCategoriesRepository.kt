package com.mobile.venky.kmm.ktor.poc.android.data.repository

import com.mobile.venky.kmm.ktor.poc.android.data.api.WebServiceApi
import com.mobile.venky.kmm.ktor.poc.android.model.MovieItem
import com.mobile.venky.kmm.ktor.poc.dto.RootMovieResponse
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Venky Maganahalli updated on 08/29/2021
 */

@Singleton
class MovieCategoriesRepository @Inject constructor(private val movieService: WebServiceApi){
    private var cachedCategories: List<MovieItem>? = null

    suspend fun getMovieCategories(): List<MovieItem> {
        var cachedCategories = cachedCategories
        if (cachedCategories == null) {
            cachedCategories = movieService.getPopularMovies().mapCategoriesToItems()
            this.cachedCategories = cachedCategories
        }
        return cachedCategories
    }

    suspend fun getMovieById(movieId: String): MovieItem {
        return getMovieCategories().first { it.id == movieId }
    }


    private fun RootMovieResponse.mapCategoriesToItems(): List<MovieItem> {
        return this.results.map { movie ->
            MovieItem(
                id = movie.id.toString(),
                name = movie.title,
                description = movie.overview,
                thumbnailUrl = movie.poster_path
            )
        }
    }



}