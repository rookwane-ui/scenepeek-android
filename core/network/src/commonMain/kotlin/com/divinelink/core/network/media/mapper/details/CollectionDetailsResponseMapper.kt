package com.divinelink.core.network.media.mapper.details

import com.divinelink.core.model.details.Collection
import com.divinelink.core.model.details.CollectionDetails
import com.divinelink.core.network.media.model.details.CollectionDetailsResponse
import com.divinelink.core.network.media.model.movie.toMovie

fun CollectionDetailsResponse.map() = CollectionDetails(
  collection = Collection(
    id = id,
    name = name,
    posterPath = posterPath,
    backdropPath = backdropPath,
  ),
  overview = overview,
  movies = parts.map { it.toMovie() },
)
