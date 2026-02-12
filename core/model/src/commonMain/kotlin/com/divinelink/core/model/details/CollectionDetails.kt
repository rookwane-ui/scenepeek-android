package com.divinelink.core.model.details

import com.divinelink.core.model.media.MediaItem
import kotlinx.serialization.Serializable

@Serializable
data class CollectionDetails(
  val collection: Collection,
  val overview: String,
  val movies: List<MediaItem.Media.Movie>,
)
