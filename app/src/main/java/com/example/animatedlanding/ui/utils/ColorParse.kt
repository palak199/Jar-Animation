package com.example.animatedlanding.ui.utils

import androidx.compose.ui.graphics.Color

fun safeParseColor(colorString: String?, fallback: Color = Color.Gray): Color {
    return try {
        colorString?.let { Color(android.graphics.Color.parseColor(it)) } ?: fallback
    } catch (e: Exception) {
        fallback
    }
}