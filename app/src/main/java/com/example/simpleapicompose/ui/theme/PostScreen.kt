package com.example.simpleapicompose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.simpleapicompose.data.model.Post

@Composable
fun PostScreen(
    state: PostUiState,
    posts: List<Post>,
    filters: PostFilters,
    onQueryChange: (String) -> Unit,
    onUserIdChange: (Int?) -> Unit,
    onMaxItemsChange: (Int?) -> Unit,
    onSortByChange: (SortBy) -> Unit,
    onRetry: () -> Unit
) {
    when (state) {
        is PostUiState.Loading -> {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is PostUiState.Error -> {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Ocurrió un error: \n${state.message}")
                    Spacer(Modifier.height(12.dp))
                    Button(onClick = onRetry) {
                        Text("Reintentar")
                    }
                }
            }
        }
        is PostUiState.Success -> {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {
                // --- Barra de búsqueda ---
                // Se cambió TextField por OutlinedTextField para un mejor diseño
                OutlinedTextField(
                    value = filters.query,
                    onValueChange = onQueryChange,
                    placeholder = { Text("Buscar por título o contenido") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(10.dp))

                // --- Filtro por userId ---
                Text("Filtrar por userId", style = MaterialTheme.typography.labelLarge)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    FilterChip(
                        selected = filters.userId == null,
                        onClick = { onUserIdChange(null) },
                        label = { Text("Todos") }
                    )
                    listOf(1, 2, 3, 4, 5).forEach { uid ->
                        FilterChip(
                            selected = filters.userId == uid,
                            onClick = { onUserIdChange(uid) },
                            label = { Text("$uid") }
                        )
                    }
                }
                Spacer(Modifier.height(10.dp))

                // --- Límite de resultados ---
                Text("Límite", style = MaterialTheme.typography.labelLarge)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    AssistChip(
                        onClick = { onMaxItemsChange(3) },
                        label = { Text("Top 3") }
                    )
                    AssistChip(
                        onClick = { onMaxItemsChange(5) },
                        label = { Text("Top 5") }
                    )
                    AssistChip(
                        onClick = { onMaxItemsChange(null) },
                        label = { Text("Todos") }
                    )
                }
                Spacer(Modifier.height(10.dp))

                // --- Opciones de ordenamiento ---
                Text("Orden", style = MaterialTheme.typography.labelLarge)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    AssistChip(
                        onClick = { onSortByChange(SortBy.TITLE_ASC) },
                        label = { Text("A→Z título") }
                    )
                    AssistChip(
                        onClick = { onSortByChange(SortBy.TITLE_DESC) },
                        label = { Text("Z→A título") }
                    )
                    AssistChip(
                        onClick = { onSortByChange(SortBy.ID_ASC) },
                        label = { Text("ID ↑") }
                    )
                    AssistChip(
                        onClick = { onSortByChange(SortBy.ID_DESC) },
                        label = { Text("ID ↓") }
                    )
                }
                Spacer(Modifier.height(12.dp))

                // --- Lista de Posts ---
                if (posts.isEmpty()) {
                    Box(
                        Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Sin resultados con los filtros actuales")
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(posts) { post ->
                            Card {
                                Column(Modifier.padding(12.dp)) {
                                    Text(
                                        post.title,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Spacer(Modifier.height(6.dp))
                                    Text(
                                        post.body,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
