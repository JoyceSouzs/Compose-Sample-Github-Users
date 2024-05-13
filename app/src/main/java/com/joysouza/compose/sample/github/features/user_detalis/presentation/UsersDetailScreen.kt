package com.joysouza.compose.sample.github.features.user_detalis.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.joysouza.compose.sample.github.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsersDetailScreen(
    userLogin: String,
    onBackButtonClicked: () -> Unit
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
                },
                navigationIcon = {
                    IconButton(onClick = { onBackButtonClicked() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }
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
}

@Preview(showBackground = true)
@Composable
fun PreviewLaunchDetails() {
    UsersDetailScreen(
        userLogin = "Em breve... Informações de ",
        onBackButtonClicked = {}
    )
}
