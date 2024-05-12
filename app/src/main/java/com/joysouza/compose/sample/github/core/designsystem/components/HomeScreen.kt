package com.joysouza.compose.sample.github.core.designsystem.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.joysouza.compose.sample.github.R
import com.joysouza.compose.sample.github.core.designsystem.theme.ComposeSimpleGitHubTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    content: @Composable (PaddingValues) -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(text = stringResource(id = R.string.top_bar_title))
                }
            )
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            content(it)
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    ComposeSimpleGitHubTheme {
        HomeScreen()
    }
}

