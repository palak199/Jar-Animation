package com.example.animatedlanding.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.animatedlanding.ui.utils.safeParseColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolBarSection(color: String?) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = safeParseColor(color),
        ),
        navigationIcon = {
            IconButton(onClick = { /* Do something */ }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Search", tint = Color.White)

            }
        },
        title = {
            Text("Onboarding", color= Color.White)
        }
    )
}
