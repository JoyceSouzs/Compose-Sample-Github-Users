package com.joysouza.compose.sample.github.features.user_detalis.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joysouza.compose.sample.github.core.ResultData
import com.joysouza.compose.sample.github.features.user_detalis.domain.GetUserDetailUseCase
import com.joysouza.compose.sample.github.features.user_detalis.domain.toUserDetailPresentation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserDetailViewModel(private val userDetailUseCase: GetUserDetailUseCase) : ViewModel() {
    private val _uiState: MutableStateFlow<UserDetailUiState> = MutableStateFlow(
        UserDetailUiState.Loading
    )
    val uiState: StateFlow<UserDetailUiState>
        get() = _uiState.asStateFlow()

    fun getUser(userLogin: String) {
        viewModelScope.launch {
            setLoading()
            when (val resultData = userDetailUseCase.invoke(userLogin)) {
                is ResultData.Success -> {
                    setSuccess(resultData.data.toUserDetailPresentation())
                }

                is ResultData.Failure -> {
                    setError(resultData.throwable)
                }
            }
        }
    }

    private fun setError(e: Throwable) {
        _uiState.value = UserDetailUiState.Error(e)
    }

    private fun setLoading() {
        _uiState.value = UserDetailUiState.Loading
    }

    private fun setSuccess(userDetail: UserDetail) {
        _uiState.value = UserDetailUiState.Success(userDetail)
    }
}

sealed interface UserDetailUiState {
    data object Loading : UserDetailUiState
    data class Success(val data: UserDetail) : UserDetailUiState
    data class Error(val throwable: Throwable) : UserDetailUiState
}
