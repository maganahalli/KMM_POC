package com.mobile.venky.kmm.ktor.poc.android.ui.movie.category_details

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.mobile.venky.kmm.ktor.poc.android.model.MovieItem
import com.mobile.venky.kmm.ktor.poc.android.ui.movie.categories.MovieItemDetails
import com.mobile.venky.kmm.ktor.poc.android.ui.movie.categories.MovieItemRow
import kotlin.math.min

/**
 * @author Venky Maganahalli updated on 08/29/2021
 */

@Composable
fun MovieCategoryDetailsScreen(state: MovieCategoryDetailsContract.State) {
    val scrollState = rememberLazyListState()
    val scrollOffset: Float = min(
        1f,
        1 - (scrollState.firstVisibleItemScrollOffset / 600f + scrollState.firstVisibleItemIndex)
    )
    Surface(color = MaterialTheme.colors.background) {
        Column {
            Surface(elevation = 4.dp) {
                CategoryDetailsCollapsingToolbar(state.category, scrollOffset)
            }
            Spacer(modifier = Modifier.height(2.dp))
            LazyColumn(
                state = scrollState,
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(state.categoryMovieItems) { item ->
                    MovieItemRow(
                        item = item,
                        iconTransformationBuilder = {
                            transformations(
                                CircleCropTransformation()
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun CategoryDetailsCollapsingToolbar(
    category: MovieItem?,
    scrollOffset: Float,
) {
    val imageSize by animateDpAsState(targetValue = max(72.dp, 128.dp * scrollOffset))
    Row {
        Card(
            modifier = Modifier.padding(16.dp),
            shape = CircleShape,
            border = BorderStroke(
                width = 2.dp,
                color = Color.Black
            ),
            elevation = 4.dp
        ) {
            Image(
                painter = rememberImagePainter(
                    data = category?.thumbnailUrl,
                    builder = {
                        transformations(CircleCropTransformation())
                    },
                ),
                modifier = Modifier.size(max(72.dp, imageSize)),
                contentDescription = "Food category thumbnail picture",
            )
        }
        MovieItemDetails(
            item = category,
            expandedLines = (kotlin.math.max(3f, scrollOffset * 6)).toInt(),
            modifier = Modifier
                .padding(
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 16.dp
                )
                .fillMaxWidth()
        )
    }
}