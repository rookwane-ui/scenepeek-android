package com.divinelink.scenepeek

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.divinelink.core.scaffold.ScenePeekApp
import com.divinelink.core.scaffold.rememberScenePeekAppState
import com.divinelink.core.ui.MainUiEvent
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.divinelink.feature.details.media.ui.VidsrcPlayerScreen

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
  private val viewModel: MainViewModel by viewModel()

  override fun onNewIntent(intent: Intent) {
    super.onNewIntent(intent)
    handleIntent(intent)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    handleIntent(intent)
    enableEdgeToEdge()
    setContent {
      // ✅ UI State from ViewModel
      val uiState by viewModel.uiState.collectAsStateWithLifecycle()
      val uiEvent by viewModel.uiEvent.collectAsStateWithLifecycle()

      // ✅ Main app content
      val state = rememberScenePeekAppState(
        onboardingManager = viewModel.onboardingManager,
        networkMonitor = viewModel.networkMonitor,
        preferencesRepository = viewModel.preferencesRepository,
        navigationProvider = viewModel.navigationProviders,
      )

      ScenePeekApp(
        state = state,
        uiState = uiState,
        uiEvent = uiEvent,
        onConsumeEvent = viewModel::consumeUiEvent,
      )

      // ✅ Vidsrc player overlay (بعد ScenePeekApp)
      var showVidsrcPlayer by remember { mutableStateOf<Pair<Int, String>?>(null) }

      LaunchedEffect(uiEvent) {
        if (uiEvent is MainUiEvent.NavigateToVidsrcPlayer) {
          val event = uiEvent as MainUiEvent.NavigateToVidsrcPlayer
          showVidsrcPlayer = event.mediaId to event.mediaType
        }
      }

      showVidsrcPlayer?.let { (id, type) ->
        VidsrcPlayerScreen(
          mediaId = id,
          mediaType = type,
          onClose = { showVidsrcPlayer = null }
        )
      }
    }
  }

  private fun handleIntent(intent: Intent?) {
    if (intent != null && intent.action == Intent.ACTION_VIEW) {
      viewModel.handleDeepLink(intent.data.toString())
    }
  }
}
