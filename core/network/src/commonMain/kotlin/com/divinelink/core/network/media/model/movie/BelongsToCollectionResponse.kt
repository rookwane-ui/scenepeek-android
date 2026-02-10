package com.divinelink.core.network.media.model.movie

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BelongsToCollectionResponse(
  val id: Int,
  val name: String,
  @SerialName("poster_path") val posterPath: String?,
  @SerialName("backdrop_path") val backdropPath: String?,
)
