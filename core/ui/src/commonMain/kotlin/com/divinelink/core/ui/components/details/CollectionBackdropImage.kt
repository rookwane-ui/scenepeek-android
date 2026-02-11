package com.divinelink.core.ui.components.details

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.divinelink.core.ui.UiString
import com.divinelink.core.ui.coil.platformContext
import com.divinelink.core.ui.rememberConstants
import com.divinelink.core.ui.resources.core_ui_backdrop_image_placeholder
import org.jetbrains.compose.resources.stringResource

@Composable
fun CollectionBackdropImage(
  path: String?,
  modifier: Modifier = Modifier,
  contentScale: ContentScale = ContentScale.FillWidth,
) {
  val constants = rememberConstants()

  AsyncImage(
    modifier = modifier
      .alpha(0.5f)
      .aspectRatio(16f / 9f)
      .fillMaxWidth(),
    model = ImageRequest.Builder(platformContext())
      .memoryCachePolicy(CachePolicy.ENABLED)
      .diskCachePolicy(CachePolicy.ENABLED)
      .data(constants.backdropUrl + path)
      .crossfade(true)
      .build(),
    contentDescription = stringResource(UiString.core_ui_backdrop_image_placeholder),
    contentScale = contentScale,
  )
}
