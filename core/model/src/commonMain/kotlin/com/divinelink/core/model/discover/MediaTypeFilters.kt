package com.divinelink.core.model.discover

import com.divinelink.core.model.Genre
import com.divinelink.core.model.details.Keyword
import com.divinelink.core.model.locale.Country
import com.divinelink.core.model.locale.Language

data class MediaTypeFilters(
  val genres: List<Genre>,
  val language: Language?,
  val country: Country?,
  val year: DiscoverFilter.Year?,
  val voteAverage: DiscoverFilter.VoteAverage?,
  val votes: Int?,
  val keywords: List<Keyword>,
) {
  companion object {
    val initial = MediaTypeFilters(
      genres = emptyList(),
      keywords = emptyList(),
      year = null,
      language = null,
      country = null,
      voteAverage = null,
      votes = null,
    )
  }

  val hasSelectedFilters
    get() = genres.isNotEmpty() ||
      keywords.isNotEmpty() ||
      language != null ||
      country != null ||
      voteAverage != null ||
      votes != null ||
      year != null

  val firstSelectedFilterIndex: Int = when {
    genres.isNotEmpty() -> 0
    year != null -> 1
    language != null -> 2
    country != null -> 3
    voteAverage != null -> 4
    votes != null -> 5
    keywords.isNotEmpty() -> 6
    else -> 0
  }
}
