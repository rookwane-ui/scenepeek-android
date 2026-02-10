package com.divinelink.feature.collections.ui

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.divinelink.core.designsystem.theme.dimensions
import com.divinelink.core.navigation.route.Navigation
import com.divinelink.core.ui.Previews
import com.divinelink.core.ui.SharedTransitionScopeProvider
import com.divinelink.core.ui.collapsingheader.ui.DetailCollapsibleContent
import com.divinelink.core.ui.composition.PreviewLocalProvider
import com.divinelink.feature.collections.CollectionsUiState
import com.divinelink.feature.collections.ui.provider.CollectionsUiStateParameterProvider

@Composable
fun SharedTransitionScope.CollectionsContent(
  visibilityScope: AnimatedVisibilityScope,
  uiState: CollectionsUiState,
  onBackdropLoaded: () -> Unit,
  toolbarProgress: (Float) -> Unit,
  onNavigate: (Navigation) -> Unit,
) {
  DetailCollapsibleContent(
    visibilityScope = visibilityScope,
    backdropPath = uiState.backdropPath,
    posterPath = uiState.posterPath,
    toolbarProgress = toolbarProgress,
    onBackdropLoaded = onBackdropLoaded,
    onNavigateToMediaPoster = { onNavigate(Navigation.MediaPosterRoute(it)) },
    headerContent = {
      Text(
        text = uiState.collectionName,
        style = MaterialTheme.typography.titleLarge,
      )
    },
    content = {
      Column(
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.keyline_8),
      ) {
        Text(
          modifier = Modifier.padding(horizontal = MaterialTheme.dimensions.keyline_16),
          text = "",
          style = MaterialTheme.typography.bodySmall,
        )
      }
    },
  )
}

@Composable
@Previews
fun CollectionsContentPreview(@PreviewParameter(CollectionsUiStateParameterProvider::class) state: CollectionsUiState) {
  PreviewLocalProvider {
    SharedTransitionScopeProvider { scope ->
      scope.CollectionsContent(
        visibilityScope = this,
        uiState = state,
        onBackdropLoaded = {},
        toolbarProgress = {},
        onNavigate = {},
      )
    }
  }
}
