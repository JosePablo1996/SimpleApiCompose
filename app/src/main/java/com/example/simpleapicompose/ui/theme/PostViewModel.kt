package com.example.simpleapicompose.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleapicompose.data.model.Post
import com.example.simpleapicompose.domain.PostRepository
import kotlinx.coroutines.launch

// Definición de los posibles estados de la UI
sealed class PostUiState {
    object Loading : PostUiState()
    data class Success(val posts: List<Post>) : PostUiState()
    data class Error(val message: String) : PostUiState()
}

class PostViewModel(
    private val repository: PostRepository = PostRepository()
) : ViewModel() {
    // Estado de la UI, observable por la vista
    var uiState: PostUiState by mutableStateOf(PostUiState.Loading)
        private set

    // Lista completa de posts obtenida de la API, se almacena en caché
    private var allPosts: List<Post> = emptyList()

    // Estado actual de los filtros
    var filters: PostFilters by mutableStateOf(PostFilters())
        private set

    // Lista filtrada que se deriva del estado de los filtros y la lista completa
    val filteredPosts: List<Post>
        get() = applyFilters()

    // Inicializamos el ViewModel cargando los datos
    init {
        loadPosts()
    }

    // Función para cargar los posts de la API
    fun loadPosts() {
        uiState = PostUiState.Loading
        viewModelScope.launch {
            try {
                // Obtenemos los posts del repositorio y los guardamos en allPosts
                allPosts = repository.fetchPosts()
                uiState = PostUiState.Success(allPosts)
            } catch (e: Exception) {
                // En caso de error, actualizamos el estado
                uiState = PostUiState.Error(e.localizedMessage ?: "Error desconocido")
            }
        }
    }

    // --- Funciones para actualizar los filtros ---
    fun updateQuery(q: String) {
        filters = filters.copy(query = q)
    }

    fun updateUserId(uid: Int?) {
        filters = filters.copy(userId = uid)
    }

    fun updateMaxItems(n: Int?) {
        filters = filters.copy(maxItems = n)
    }

    fun updateSortBy(s: SortBy) {
        filters = filters.copy(sortBy = s)
    }

    // --- Lógica para aplicar los filtros ---
    private fun applyFilters(): List<Post> {
        var result = allPosts

        // 1) Filtrar por texto en el título o cuerpo
        val q = filters.query.trim()
        if (q.isNotEmpty()) {
            result = result.filter { p ->
                p.title.contains(q, ignoreCase = true) || p.body.contains(q, ignoreCase = true)
            }
        }

        // 2) Filtrar por ID de usuario (si se especifica)
        filters.userId?.let { uid ->
            result = result.filter { it.userId == uid }
        }

        // 3) Ordenar la lista según la opción seleccionada
        result = when (filters.sortBy) {
            SortBy.TITLE_ASC -> result.sortedBy { it.title.lowercase() }
            SortBy.TITLE_DESC -> result.sortedByDescending { it.title.lowercase() }
            SortBy.ID_ASC -> result.sortedBy { it.id }
            SortBy.ID_DESC -> result.sortedByDescending { it.id }
            SortBy.NONE -> result
        }

        // 4) Limitar la cantidad de elementos
        filters.maxItems?.let { n ->
            result = result.take(n)
        }

        return result
    }
}
