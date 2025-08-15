package com.example.simpleapicompose.ui

// Creamos un enum para definir las opciones de ordenamiento
enum class SortBy {
    NONE,
    TITLE_ASC,
    TITLE_DESC,
    ID_ASC,
    ID_DESC
}

// Creamos una data class que representa los filtros de la lista de posts
// Se inicializa con valores por defecto para cada filtro
data class PostFilters(
    val query: String = "",         // Campo de búsqueda por texto
    val userId: Int? = null,        // Filtro por ID de usuario (null = todos)
    val maxItems: Int? = null,      // Límite de elementos (null = sin límite)
    val sortBy: SortBy = SortBy.NONE // Opción de ordenamiento
)
