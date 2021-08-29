package com.mobile.venky.kmm.ktor.poc.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mobile.venky.kmm.ktor.poc.android.data.repository.MovieCategoriesRepositoryNoHilt
import com.mobile.venky.kmm.ktor.poc.android.model.MovieItem

/**
 * @author Venky Maganahalli updated on 08/29/2021
 */
class MainViewModel : ViewModel() {

    private val repository: MovieCategoriesRepositoryNoHilt =
        lazy { MovieCategoriesRepositoryNoHilt() }.value


    val movies: LiveData<List<MovieItem>> = liveData {
        emit(repository.getMovieCategories())
    }


}