package com.divinelink.feature.collections

import com.divinelink.core.model.media.MediaItem
import com.divinelink.core.navigation.route.Navigation
import com.divinelink.core.ui.blankslate.BlankSlateState

data class CollectionsUiState(
  val id: Int,
  val collectionName: String,
  val backdropPath: String?,
  val posterPath: String?,
  val loading: Boolean,
  val error: BlankSlateState?,
  val overview: String?,
  val movies: List<MediaItem.Media.Movie>,
) {
  companion object {
    fun initial(route: Navigation.CollectionRoute) = CollectionsUiState(
      id = route.id,
      collectionName = route.name,
      backdropPath = route.backdropPath,
      posterPath = route.posterPath,
      error = null,
      overview = null,
      loading = true,
      movies = emptyList(),
    )
  }
}
