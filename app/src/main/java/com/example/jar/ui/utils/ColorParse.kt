package com.example.jar.ui.utils

import androidx.compose.ui.graphics.Color

fun safeParseColor(colorString: String?, fallback: String = "#272239"): Color {
    return try {
        if (!colorString.isNullOrBlank()) {
            Color(android.graphics.Color.parseColor(colorString))
        } else {
            Color(android.graphics.Color.parseColor(fallback))
        }
    } catch (e: Exception) {
        Color(android.graphics.Color.parseColor(fallback))
    }
}
