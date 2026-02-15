package com.divinelink.core.network.media.model.search

import com.divinelink.core.network.media.model.details.KeywordResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchKeywordResponse(
  val page: Int,
  val results: List<KeywordResponse>,
  @SerialName("total_pages") val totalPages: Int,
  @SerialName("total_results") val totalResults: Int,
)
