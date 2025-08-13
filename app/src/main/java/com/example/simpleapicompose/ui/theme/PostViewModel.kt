package com.example.simpleapicompose.ui.theme




import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleapicompose.data.model.Post
import com.example.simpleapicompose.domain.PostRepository
import kotlinx.coroutines.launch

sealed class PostUiState {
    object Loading : PostUiState()
    data class Success(val posts: List<Post>) : PostUiState()
    data class Error(val message: String) : PostUiState()
}

class PostViewModel(
    private val repository: PostRepository = PostRepository()
) : ViewModel() {

    var uiState: PostUiState by mutableStateOf(PostUiState.Loading)
        private set

    init {
        loadPosts()
    }

    fun loadPosts() {
        uiState = PostUiState.Loading
        viewModelScope.launch {
            try {
                val data = repository.fetchPosts()
                uiState = PostUiState.Success(data)
            } catch (e: Exception) {
                uiState = PostUiState.Error(e.localizedMessage ?: "Error desconocido")
            }
        }
    }
}
