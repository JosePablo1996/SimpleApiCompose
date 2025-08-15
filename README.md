SimpleApiCompose

Una aplicación de ejemplo para Android que consume una API REST pública (JSONPlaceholder) y muestra la información en una lista usando Jetpack Compose. El proyecto demuestra el uso de una arquitectura modular y moderna, incluyendo filtros y ordenamiento de datos.

Características Principales
Consumo de API REST: Utiliza Retrofit y Moshi para realizar peticiones HTTP a la API de JSONPlaceholder.

Interfaz de Usuario: La interfaz está construida completamente con Jetpack Compose y el diseño de Material 3.

Filtros de Búsqueda: Permite buscar posts por título o contenido, filtrar por userId y limitar el número de resultados.

Ordenamiento: Los posts pueden ser ordenados por título (ascendente/descendente) e ID (ascendente/descendente).

Arquitectura: Sigue las mejores prácticas con un patrón MVVM (Model-View-ViewModel) usando ViewModel y un Repository para la gestión de datos.

Tecnologías Utilizadas
Kotlin: El lenguaje principal de desarrollo.

Jetpack Compose: El toolkit moderno para construir la UI nativa de Android.

Retrofit: Un cliente HTTP para el consumo de la API.

Moshi: Un conversor de JSON a objetos Kotlin.

Coroutines: Para la gestión de tareas asíncronas de manera simple y segura.

Material 3: El sistema de diseño de Google para la aplicación.

Configuración del Proyecto
Para ejecutar este proyecto de forma local, sigue estos pasos:

Clona el repositorio:
git clone https://github.com/JosePablo1996/SimpleApiCompose.git

Abre el proyecto: Abre el proyecto en Android Studio.

Sincroniza Gradle: Espera a que Android Studio sincronice las dependencias de Gradle.

Ejecuta la aplicación: Conecta un dispositivo Android o usa un emulador, y haz clic en el botón de "Run" en Android Studio.