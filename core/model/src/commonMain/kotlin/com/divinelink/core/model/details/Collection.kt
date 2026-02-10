package com.divinelink.core.model.details

import kotlinx.serialization.Serializable

@Serializable
data class Collection(
  val id: Int,
  val name: String,
  val posterPath: String?,
  val backdropPath: String?,
)
