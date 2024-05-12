package com.joysouza.compose.sample.github.features.users.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joysouza.compose.sample.github.core.ResultData
import com.joysouza.compose.sample.github.features.users.domain.GetUsersUseCase
import com.joysouza.compose.sample.github.features.users.domain.toUserPresentation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UsersViewModel(private val usersUseCase: GetUsersUseCase) : ViewModel() {
    private val _uiState: MutableStateFlow<UserListUiState> = MutableStateFlow(
        UserListUiState.Loading
    )
    val uiState: StateFlow<UserListUiState>
        get() = _uiState.asStateFlow()

    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            setLoading()
            when (val resultData = usersUseCase.invoke()) {
                is ResultData.Success -> {
                    val items = resultData.data.map {
                        it.toUserPresentation()
                    }
                    setSuccess(items)
                }

                is ResultData.Failure -> {
                    setError(resultData.throwable)
                }
            }
        }
    }

    private fun setError(e: Throwable) {
        _uiState.value = UserListUiState.Error(e)
    }

    private fun setLoading() {
        _uiState.value = UserListUiState.Loading
    }

    private fun setSuccess(items: List<User>) {
        _uiState.value = UserListUiState.Success(items)
    }
}

sealed interface UserListUiState {
    data object Loading : UserListUiState
    data class Success(val data: List<User>) : UserListUiState
    data class Error(val throwable: Throwable) : UserListUiState
}
