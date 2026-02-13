package com.divinelink.core.fixtures.model.details

import com.divinelink.core.model.details.Keyword

object KeywordFactory {

  val basedOnNovelOrBook = Keyword(
    id = 818,
    name = "based on novel or book",
  )

  val fight = Keyword(
    id = 1721,
    name = "fight",
  )

  val mockumentary = Keyword(
    id = 11800,
    name = "Mockumentary",
  )

  val amused = Keyword(
    id = 325765,
    name = "Amused",
  )

  val sitcom = Keyword(
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
