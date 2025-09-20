package com.example.animatedlanding

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.animatedlanding.ui.theme.AnimatedLandingTheme
import com.example.animatedlanding.ui.viewmodel.EducationViewModel

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