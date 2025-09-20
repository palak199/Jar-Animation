package com.example.jar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.jar.ui.theme.AnimatedLandingTheme
import com.example.jar.ui.viewmodel.EducationViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: EducationViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            AnimatedLandingTheme {
                    LaunchScreen(viewModel)
            }
        }
    }
}