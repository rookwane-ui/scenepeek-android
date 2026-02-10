package com.divinelink.feature.details.media.ui.forms.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import com.divinelink.core.designsystem.component.ScenePeekLazyColumn
import com.divinelink.core.designsystem.theme.LocalBottomNavigationPadding
import com.divinelink.core.designsystem.theme.dimensions
import com.divinelink.core.model.details.media.DetailsData
import com.divinelink.core.model.details.media.MediaDetailsInformation
import com.divinelink.core.navigation.route.Navigation
import com.divinelink.core.navigation.route.toPersonRoute
import com.divinelink.core.ui.TestTags
import com.divinelink.core.ui.components.details.cast.CreatorsItem
import com.divinelink.feature.details.media.ui.components.GenresSection
import com.divinelink.feature.details.media.ui.components.MovieInformationSection
import com.divinelink.feature.details.media.ui.components.TvInformationSection

@Composable
fun AboutFormContent(
  modifier: Modifier = Modifier,
  aboutData: DetailsData.About,
  onNavigate: (Navigation) -> Unit,
) {
  ScenePeekLazyColumn(
    modifier = modifier.testTag(TestTags.Details.About.FORM),
    contentPadding = PaddingValues(
      top = MaterialTheme.dimensions.keyline_16,
      start = MaterialTheme.dimensions.keyline_16,
      end = MaterialTheme.dimensions.keyline_16,
    ),
    verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.keyline_16),
  ) {
    aboutData.tagline?.let {
      item {
        Text(
          text = it,
          style = MaterialTheme.typography.bodySmall,
          fontStyle = FontStyle.Italic,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
      }
    }

    if (!aboutData.overview.isNullOrEmpty()) {
      item {
        Text(
          text = aboutData.overview!!,
          style = MaterialTheme.typography.bodyMedium,
        )
      }
      item {
        HorizontalDivider()
      }
    }

    aboutData.genres?.let { genres ->
      item {
        GenresSection(
          genres = genres,
          onGenreClick = {},
        )
      }
    }

    aboutData.creators?.let { creators ->
      item {
        CreatorsItem(
          creators = creators,
          onClick = { onNavigate(it.toPersonRoute()) },
        )
      }
    }

    aboutData.information?.let { information ->
      item {
        HorizontalDivider()
      }

      item {
        when (information) {
          is MediaDetailsInformation.Movie -> MovieInformationSection(information)
          is MediaDetailsInformation.TV -> TvInformationSection(information)
        }
      }
    }

    aboutData.collection?.let { collection ->
      item {
        CollectionBanner(
          collection = collection,
          onClick = {
            onNavigate(
              Navigation.CollectionRoute(
                id = collection.id,
                name = collection.name,
                backdropPath = collection.backdropPath,
                posterPath = collection.posterPath,
              ),
            )
          },
        )
      }
    }

    item {
      Spacer(modifier = Modifier.height(LocalBottomNavigationPadding.current))
    }
  }
}
