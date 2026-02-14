package com.divinelink.core.model.details

import kotlinx.serialization.Serializable

@Serializable
data class Keyword(
  val id: Long,
  val name: String,
)
