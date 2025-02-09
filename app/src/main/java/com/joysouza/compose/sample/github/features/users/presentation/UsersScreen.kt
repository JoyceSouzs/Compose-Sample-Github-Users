package com.joysouza.compose.sample.github.features.users.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.joysouza.compose.sample.github.core.designsystem.components.ErrorScreen
import com.joysouza.compose.sample.github.core.designsystem.components.LoadingScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun UsersScreen(
    navigateToDetail: (String) -> Unit,
    viewModel: UsersViewModel = koinViewModel()
) {
    val userState = viewModel.uiState.collectAsStateWithLifecycle()
    when (val result = userState.value) {
        is UserListUiState.Loading -> LoadingScreen()
        is UserListUiState.Success -> UserContent(result.data, navigateToDetail)
        is UserListUiState.Error -> ErrorScreen(
            onRetryClick = { viewModel.getUsers() }
        )
    }
}

@Composable
fun UserContent(users: List<User>, navigateToDetail: (String) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(
            all = 16.dp
        )
    ) {
        items(count = users.size) { item ->
            UserItem(users[item], navigateToDetail = navigateToDetail)
        }
    }
}
