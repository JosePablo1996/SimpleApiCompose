package com.example.simpleapicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simpleapicompose.ui.*

// MainActivity es el punto de entrada de la aplicación
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Configuramos el contenido de la pantalla con Jetpack Compose
        setContent {
            // Utilizamos el tema de Material 3
            MaterialTheme {
                // Surface es el contenedor principal de la UI
                Surface {
                    // Instanciamos el PostViewModel, que maneja la lógica de la UI
                    val vm: PostViewModel = viewModel()

                    // Llamamos a la función PostScreen y le pasamos los datos y las funciones
                    // de nuestro ViewModel.
                    PostScreen(
                        // Pasamos el estado de la UI (Cargando, Éxito, Error)
                        state = vm.uiState,
                        // Pasamos la lista de posts filtrada
                        posts = vm.filteredPosts,
                        // Pasamos el estado de los filtros
                        filters = vm.filters,
                        // Pasamos las funciones del ViewModel para actualizar los filtros
                        onQueryChange = vm::updateQuery,
                        onUserIdChange = vm::updateUserId,
                        onMaxItemsChange = vm::updateMaxItems,
                        onSortByChange = vm::updateSortBy,
                        // Pasamos la función para reintentar la carga en caso de error
                        onRetry = { vm.loadPosts() }
                    )
                }
            }
        }
    }
}
