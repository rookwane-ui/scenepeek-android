package com.divinelink.feature.collections.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.divinelink.core.navigation.route.Navigation
import com.divinelink.feature.collections.ui.CollectionsScreen

fun NavGraphBuilder.collectionsScreen(onNavigate: (Navigation) -> Unit) {
  composable<Navigation.CollectionRoute> {
    CollectionsScreen(
      onNavigate = onNavigate,
    )
  }
}
