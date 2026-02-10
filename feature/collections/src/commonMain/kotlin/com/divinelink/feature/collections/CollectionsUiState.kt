package com.divinelink.feature.collections

import com.divinelink.core.navigation.route.Navigation

data class CollectionsUiState(
  val id: Int,
  val collectionName: String,
  val backdropPath: String?,
  val posterPath: String?,
) {
  companion object {
    fun initial(route: Navigation.CollectionRoute) = CollectionsUiState(
      id = route.id,
      collectionName = route.name,
      backdropPath = route.backdropPath,
      posterPath = route.posterPath,
    )
  }
}
