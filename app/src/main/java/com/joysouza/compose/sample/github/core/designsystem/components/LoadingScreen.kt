package com.joysouza.compose.sample.github.core.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joysouza.compose.sample.github.R
import com.joysouza.compose.sample.github.core.designsystem.theme.ComposeSimpleGitHubTheme
import androidx.compose.ui.res.stringResource as stringResource

@Composable
fun LoadingScreen(
    message: String? = null,
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            Modifier.semantics {
                contentDescription = "Indicador de progresso"
            },
            color = MaterialTheme.colorScheme.primaryContainer
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = message ?: stringResource(id = R.string.generic_loading_message))
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewGenericLoadingScreen() {
    ComposeSimpleGitHubTheme {
        LoadingScreen()
    }
}
