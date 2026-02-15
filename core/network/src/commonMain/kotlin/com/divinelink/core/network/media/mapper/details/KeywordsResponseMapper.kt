package com.divinelink.core.network.media.mapper.details

import com.divinelink.core.model.details.Keyword
import com.divinelink.core.network.media.model.details.KeywordResponse
import com.divinelink.core.network.media.model.details.KeywordsResponse

fun KeywordsResponse?.map() = this
  ?.keywords
  ?.map { it.map() }

fun KeywordResponse.map() = Keyword(
  id = id,
  name = name,
)
