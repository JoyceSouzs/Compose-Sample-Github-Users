package com.joysouza.compose.sample.github.users.presentation

import com.joysouza.compose.sample.github.core.ResultData
import com.joysouza.compose.sample.github.features.users.domain.GetUsersUseCase
import com.joysouza.compose.sample.github.features.users.domain.User
import com.joysouza.compose.sample.github.features.users.presentation.UserListUiState
import com.joysouza.compose.sample.github.features.users.presentation.UsersViewModel
import io.mockk.clearAllMocks
import com.joysouza.compose.sample.github.features.users.presentation.User as UserPresentation
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UsersViewModelTest {
    private val dispatcher = StandardTestDispatcher()
    private val useCase = mockk<GetUsersUseCase>()
    private lateinit var viewModel: UsersViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = UsersViewModel(useCase)
    }

    @After
    fun tearDown() {
        confirmVerified(useCase)
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `when use case is invoke should set UserListUiState loading and success`() {
        val fakeUserDomain = listOf(
            User(
                login = "login",
                htmlUrl = "htmlUrl",
                avatarUrl = "avatarUrl"
            )
        )
        val resultData = ResultData.Success(fakeUserDomain)
        val fakeUserPresentation = listOf(
            UserPresentation(
                login = "login",
                htmlUrl = "htmlUrl",
                avatarUrl = "avatarUrl"
            )
        )
        val expected = UserListUiState.Success(fakeUserPresentation)
        val results = mutableListOf<UserListUiState>()

        coEvery { useCase.invoke() } coAnswers {
            delay(1000)
            resultData
        }
        runTest {
            viewModel.uiState
                .take(2)
                .collect {
                    results.add(it)
                }
        }

        Assert.assertEquals(2, results.size)
        Assert.assertTrue(results[0] is UserListUiState.Loading)
        Assert.assertTrue(results[1] is UserListUiState.Success)
        Assert.assertEquals(expected, viewModel.uiState.value)
        coVerify(exactly = 1) {
            useCase.invoke()
        }
    }

    @Test
    fun `when use case is invoke should set UserListUiState loading and error`() {
        val error = Throwable("Error")
        val resultData = ResultData.Failure(error)
        val expected = UserListUiState.Error(error)
        val results = mutableListOf<UserListUiState>()

        coEvery { useCase.invoke() } coAnswers {
            delay(1000)
            resultData
        }
        runTest {
            viewModel.uiState
                .take(2)
                .collect {
                    results.add(it)
                }
        }

        Assert.assertEquals(2, results.size)
        Assert.assertTrue(results[0] is UserListUiState.Loading)
        Assert.assertTrue(results[1] is UserListUiState.Error)
        Assert.assertEquals(expected, viewModel.uiState.value)
        coVerify(exactly = 1) {
            useCase.invoke()
        }
    }
}
