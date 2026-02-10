package com.divinelink.feature.collections

sealed interface CollectionsAction {
  data object Refresh : CollectionsAction
}
