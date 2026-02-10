package com.divinelink.core.network.media.mapper.details

import com.divinelink.core.model.details.Collection
import com.divinelink.core.network.media.model.movie.BelongsToCollectionResponse

fun BelongsToCollectionResponse.map() = Collection(
  id = id,
  name = name,
  posterPath = posterPath,
  backdropPath = backdropPath,
)
