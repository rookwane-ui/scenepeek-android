package com.divinelink.feature.details.media.ui.forms.about

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
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
import com.divinelink.core.ui.conditional
import com.divinelink.feature.details.resources.Res
import com.divinelink.feature.details.resources.feature_details_part_of_collection
import com.divinelink.feature.details.resources.feature_details_view_collection
import org.jetbrains.compose.resources.stringResource

@Composable
fun CollectionBanner(
  modifier: Modifier = Modifier,
  collection: Collection,
  onClick: () -> Unit,
) {
  Box(
    modifier = modifier
      .clip(MaterialTheme.shapes.medium)
      .clickable(onClick = onClick)
      .fillMaxWidth(),
  ) {
    if (collection.backdropPath?.isNotEmpty() == true) {
      CollectionBackdropImage(
        path = collection.backdropPath,
      )
    }

    Column(
      modifier = Modifier
        .fillMaxWidth()
        .conditional(
          condition = collection.backdropPath?.isNotEmpty() == true,
          ifTrue = { matchParentSize() },
          ifFalse = { fillMaxHeight() },
        ),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.SpaceBetween,
    ) {
      Text(
        modifier = Modifier.padding(MaterialTheme.dimensions.keyline_16),
        text = stringResource(Res.string.feature_details_part_of_collection, collection.name),
        style = MaterialTheme.typography.titleLarge,
      )

      TextButton(
        modifier = Modifier
          .padding(bottom = MaterialTheme.dimensions.keyline_4),
        onClick = onClick,
        colors = ButtonDefaults.textButtonColors().copy(
          contentColor = MaterialTheme.colorScheme.onSurface,
        ),
      ) {
        Text(
          text = stringResource(Res.string.feature_details_view_collection),
          style = MaterialTheme.typography.titleSmall,
        )
      }
    }
  }
}
