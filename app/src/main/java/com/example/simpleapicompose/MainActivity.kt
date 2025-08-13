package com.example.simpleapicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simpleapicompose.ui.theme.PostScreen
import com.example.simpleapicompose.ui.theme.PostViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                Surface {
                    val vm: PostViewModel = viewModel()
                    PostScreen(
                        state = vm.uiState,
                        onRetry = { vm.loadPosts() }
                    )
                }
            }
        }
    }
}
