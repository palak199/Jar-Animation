package com.example.jar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jar.ui.utils.safeParseColor

@Composable
fun IntroSection(title: String, subtitle: String, color: String, expanded: Boolean) {
    val backgroundBrush = Brush.linearGradient(
        colors = listOf(
                        Color(0xFFA5D6A7), // soft green (matches first card)
                        Color(0xFFB39DDB)  // muted lavender (matches second card)
                    )
    )
    if(expanded) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundBrush),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(title, color=Color.White, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(subtitle, color = safeParseColor("#F8DC83"), style = MaterialTheme.typography.titleLarge)
        }
    }
}
