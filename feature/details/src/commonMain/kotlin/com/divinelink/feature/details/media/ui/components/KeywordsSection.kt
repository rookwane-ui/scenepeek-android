package com.divinelink.feature.details.media.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.divinelink.core.designsystem.theme.dimensions
import com.divinelink.core.model.details.Keyword
import com.divinelink.core.ui.UiString
import com.divinelink.core.ui.components.details.keywords.KeywordLabel
import com.divinelink.core.ui.resources.core_ui_keywords
import org.jetbrains.compose.resources.stringResource

@Composable
fun KeywordsSection(
  keywords: List<Keyword>,
  onClick: (Keyword) -> Unit,
) {
  Column {
    Text(
      modifier = Modifier.padding(
        start = MaterialTheme.dimensions.keyline_16,
        bottom = MaterialTheme.dimensions.keyline_8,
      ),
      text = stringResource(UiString.core_ui_keywords),
      style = MaterialTheme.typography.titleMedium,
    )
    FlowRow(
      modifier = Modifier.padding(horizontal = MaterialTheme.dimensions.keyline_8),
    ) {
      keywords.forEach { keyword ->
        KeywordLabel(
          keyword = keyword,
          onClick = onClick,
        )
      }
    }
  }
}
