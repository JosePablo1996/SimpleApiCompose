package com.example.simpleapicompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.simpleapicompose.R // Asegúrate de tener este archivo si vas a usar fuentes personalizadas

// Puedes definir una fuente personalizada
// private val Inter = FontFamily(
//     Font(R.font.inter_regular, FontWeight.Normal),
//     Font(R.font.inter_semibold, FontWeight.SemiBold)
// )

// Puedes usar las fuentes por defecto o definir una personalizada aquí
// Usaremos la tipografía por defecto de Material 3 para simplificar
val Typography = Typography(
    // Estilo para títulos grandes (ej. en la app bar)
    displayLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    // Estilo para títulos de tamaño medio
    displayMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    // Estilo para títulos pequeños (ej. títulos de tarjetas)
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    // Estilo para el cuerpo principal del texto (ej. contenido de posts)
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    // Estilo para etiquetas y texto pequeño (ej. en los chips de filtro)
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    )
)
