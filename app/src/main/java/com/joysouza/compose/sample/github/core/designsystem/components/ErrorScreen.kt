package com.joysouza.compose.sample.github.core.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joysouza.compose.sample.github.R
import com.joysouza.compose.sample.github.core.designsystem.theme.ComposeSimpleGitHubTheme

@Composable
fun ErrorScreen(
    message: String? = null,
    buttonTitle: String? = null,
    onRetryClick: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message ?: stringResource(id = R.string.generic_error_message),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(16.dp))
        Button(
            onClick = { onRetryClick() },
            modifier = Modifier.semantics {
                onClick(
                    label = "Toque duas vezes para tentar novamente",
                    action = null
                )
            },
        ) {
            Text(text = buttonTitle ?: stringResource(id = R.string.try_again))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewErrorScreen() {
    ComposeSimpleGitHubTheme {
        ErrorScreen(
            onRetryClick = {}
        )
    }
}
