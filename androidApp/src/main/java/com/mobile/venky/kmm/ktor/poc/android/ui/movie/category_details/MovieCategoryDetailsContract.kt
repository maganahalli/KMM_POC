package com.mobile.venky.kmm.ktor.poc.android.ui.movie.category_details

import com.mobile.venky.kmm.ktor.poc.android.base.ViewEvent
import com.mobile.venky.kmm.ktor.poc.android.base.ViewSideEffect
import com.mobile.venky.kmm.ktor.poc.android.base.ViewState
import com.mobile.venky.kmm.ktor.poc.android.model.MovieItem

/**
 * @author Venky Maganahalli updated on 08/29/2021
 */

class MovieCategoryDetailsContract {
    sealed class Event : ViewEvent

    data class State(
        val category: MovieItem?,
        val categoryMovieItems: List<MovieItem>
    ) : ViewState

    sealed class Effect : ViewSideEffect
}