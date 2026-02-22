package com.divinelink.scenepeek

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.divinelink.core.scaffold.ScenePeekApp
import com.divinelink.core.scaffold.rememberScenePeekAppState
import com.divinelink.core.ui.MainUiEvent
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.divinelink.feature.details.media.ui.VidsrcPlayerScreen
import androidx.compose.runtime.LaunchedEffect

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
      // ✅ متغيرات التحكم في شاشة vidsrc
      var showVidsrcPlayer by remember { mutableStateOf<Pair<Int, String>?>(null) }

      // ✅ استقبال الأحداث من ViewModel
      val uiEvent by viewModel.uiEvent.collectAsStateWithLifecycle()
      
      LaunchedEffect(uiEvent) {
        when (val event = uiEvent) {
          is MainUiEvent.NavigateToVidsrcPlayer -> {
            showVidsrcPlayer = event.mediaId to event.mediaType
          }
          else -> {}
        }
      }

      // ✅ عرض شاشة vidsrc لو مطلوبة
      showVidsrcPlayer?.let { (id, type) ->
        VidsrcPlayerScreen(
          mediaId = id,
          mediaType = type,
          onClose = { showVidsrcPlayer = null }
        )
      }

      // ✅ باقي التطبيق
      val uiState by viewModel.uiState.collectAsStateWithLifecycle()

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
    }
  }

  private fun handleIntent(intent: Intent?) {
    if (intent != null && intent.action == Intent.ACTION_VIEW) {
      viewModel.handleDeepLink(intent.data.toString())
    }
  }
}
