package com.divinelink.feature.details.media.ui.forms.about

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.divinelink.core.designsystem.theme.dimensions
import com.divinelink.core.model.details.Collection
import com.divinelink.core.ui.components.details.CollectionBackdropImage
import com.divinelink.feature.details.resources.Res
import com.divinelink.feature.details.resources.feature_details_part_of_collection
import com.divinelink.feature.details.resources.feature_details_view_collection
import org.jetbrains.compose.resources.stringResource

@Composable
fun CollectionBanner(
  collection: Collection,
  onClick: () -> Unit,
) {
  Box(
    modifier = Modifier
      .clip(MaterialTheme.shapes.medium)
      .clickable(onClick = onClick)
      .fillMaxWidth(),
  ) {
    CollectionBackdropImage(
      path = collection.backdropPath,
    )

    Text(
      modifier = Modifier
        .padding(MaterialTheme.dimensions.keyline_16)
        .align(Alignment.TopCenter),
      text = stringResource(Res.string.feature_details_part_of_collection, collection.name),
      style = MaterialTheme.typography.titleLarge,
    )

    TextButton(
      modifier = Modifier
        .padding(bottom = MaterialTheme.dimensions.keyline_4)
        .align(Alignment.BottomCenter),
      onClick = onClick,
    ) {
      Text(stringResource(Res.string.feature_details_view_collection))
    }
  }
}
