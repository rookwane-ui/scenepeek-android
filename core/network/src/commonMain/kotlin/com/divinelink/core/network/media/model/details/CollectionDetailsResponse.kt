package com.divinelink.core.network.media.model.details

import com.divinelink.core.network.media.model.movie.MovieResponseApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollectionDetailsResponse(
  val id: Int,
  val name: String,
  @SerialName("original_name") val originalName: String,
  val overview: String,
  @SerialName("poster_path") val posterPath: String?,
  @SerialName("backdrop_path") val backdropPath: String?,
  val parts: List<MovieResponseApi>,
)
