package com.joysouza.compose.sample.github.features.user_detalis.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.joysouza.compose.sample.github.R

@Composable
fun UsersDetailScreen(
    userLogin: String
) {
    Column(
        Modifier
            .fillMaxSize()
            .semantics { contentDescription = "Users Detail Screen" },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Em breve... Informações de $userLogin")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLaunchDetails() {
    UsersDetailScreen("Em breve... Informações de ")
}
