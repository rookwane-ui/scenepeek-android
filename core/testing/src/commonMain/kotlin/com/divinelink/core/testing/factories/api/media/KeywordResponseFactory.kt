package com.divinelink.core.testing.factories.api.media

import com.divinelink.core.network.media.model.details.KeywordResponse

object KeywordResponseFactory {

  val basedOnNovelOrBook = KeywordResponse(
    id = 818,
    name = "based on novel or book",
  )

  val fight = KeywordResponse(
    id = 1721,
    name = "fight",
  )

  val mockumentary = KeywordResponse(
    id = 11800,
    name = "Mockumentary",
  )

  val amused = KeywordResponse(
    id = 325765,
    name = "Amused",
  )

  val sitcom = KeywordResponse(
    id = 193171,
    name = "sitcom",
  )

  val theOffice = listOf(
    mockumentary,
    amused,
    sitcom,
  )

  val fightClub = listOf(
    basedOnNovelOrBook,
    fight,
  )
}
