package com.divinelink.core.testing.factories.api.media

import com.divinelink.core.network.media.model.details.KeywordsResponse

object KeywordsResponseFactory {

  val theOffice = KeywordsResponse(keywords = KeywordResponseFactory.theOffice)
  val fightClub = KeywordsResponse(keywords = KeywordResponseFactory.fightClub)
}
