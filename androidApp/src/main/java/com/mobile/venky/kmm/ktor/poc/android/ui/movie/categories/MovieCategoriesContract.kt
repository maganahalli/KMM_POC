package com.mobile.venky.kmm.ktor.poc.android.ui.movie.categories

import com.mobile.venky.kmm.ktor.poc.android.base.ViewEvent
import com.mobile.venky.kmm.ktor.poc.android.base.ViewSideEffect
import com.mobile.venky.kmm.ktor.poc.android.base.ViewState
import com.mobile.venky.kmm.ktor.poc.android.model.MovieItem

/**
 * @author Venky Maganahalli updated on 08/29/2021
 */
class MovieCategoriesContract {
    sealed class Event : ViewEvent {
        data class CategorySelection(val categoryName: String) : Event()
    }

    data class State(val categories: List<MovieItem> = listOf(), val isLoading: Boolean = false) :
        ViewState

    sealed class Effect : ViewSideEffect {
        object DataWasLoaded : Effect()

        sealed class Navigation : Effect() {
            data class ToCategoryDetails(val categoryName: String) : Navigation()
        }
    }

}