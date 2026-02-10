package com.divinelink.feature.collections

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.divinelink.core.navigation.route.Navigation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CollectionsViewModel(
  savedStateHandle: SavedStateHandle,
) : ViewModel() {

  private val route = Navigation.CollectionRoute(
    id = savedStateHandle.get<Int>("id") ?: -1,
    name = savedStateHandle.get<String>("name") ?: "",
    backdropPath = savedStateHandle.get<String>("backdropPath") ?: "",
    posterPath = savedStateHandle.get<String>("posterPath") ?: "",
  )

  private val _uiState: MutableStateFlow<CollectionsUiState> = MutableStateFlow(
    CollectionsUiState.initial(route),
  )
  val uiState: StateFlow<CollectionsUiState> = _uiState

  init {

  }
}

