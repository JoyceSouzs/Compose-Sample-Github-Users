package com.joysouza.compose.sample.github

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.joysouza.compose.sample.github.core.designsystem.theme.ComposeSimpleGitHubTheme
import com.joysouza.compose.sample.github.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSimpleGitHubTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AppNavHost()
                }
            }
        }
    }
}
