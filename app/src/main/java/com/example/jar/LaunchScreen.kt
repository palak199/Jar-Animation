package com.example.jar

import AnimationScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jar.ui.viewmodel.EducationViewModel

@Composable
fun LaunchScreen(viewModel: EducationViewModel) {
    val educationData by viewModel.uiState.collectAsState()
    if (educationData != null) {
        AnimationScreen(educationData!!)
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}

