package com.divinelink.core.network.media.model.details

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
data class KeywordResponse(
  val id: Long,
  val name: String,
)

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class KeywordsResponse(
  @JsonNames("results", "keywords") val keywords: List<KeywordResponse>,
)
