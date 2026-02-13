package com.divinelink.core.ui.components.details.keywords

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.divinelink.core.designsystem.theme.dimensions
import com.divinelink.core.model.details.Keyword

@Composable
fun KeywordLabel(
  modifier: Modifier = Modifier,
  keyword: Keyword,
  onClick: (Keyword) -> Unit,
) {
  Surface(
    shape = MaterialTheme.shapes.small,
    modifier = modifier
      .wrapContentSize(Alignment.Center)
      .wrapContentHeight()
      .clip(MaterialTheme.shapes.small)
      .clickable(onClick = { onClick(keyword) }),
  ) {
    Box {
      Text(
        modifier = Modifier
          .align(Alignment.Center)
          .padding(
            horizontal = MaterialTheme.dimensions.keyline_8,
            vertical = MaterialTheme.dimensions.keyline_8,
          ),
        textAlign = TextAlign.Center,
        text = keyword.name,
        style = MaterialTheme.typography.bodyMedium,
        fontWeight = FontWeight.Bold,
      )
    }
  }
}
