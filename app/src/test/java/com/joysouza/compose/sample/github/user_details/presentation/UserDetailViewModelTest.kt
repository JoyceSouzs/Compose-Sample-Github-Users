package com.joysouza.compose.sample.github.user_details.presentation

import com.joysouza.compose.sample.github.core.ResultData
import com.joysouza.compose.sample.github.features.user_detalis.domain.GetUserDetailUseCase
import com.joysouza.compose.sample.github.features.user_detalis.domain.UserDetail
import com.joysouza.compose.sample.github.features.user_detalis.presentation.UserDetailUiState
import com.joysouza.compose.sample.github.features.user_detalis.presentation.UserDetailViewModel
import io.mockk.clearAllMocks
import com.joysouza.compose.sample.github.features.user_detalis.presentation.UserDetail as UserDetailPresentation
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
class UserDetailViewModelTest {
    private val dispatcher = StandardTestDispatcher()
    private val useCase = mockk<GetUserDetailUseCase>()
    private lateinit var viewModel: UserDetailViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = UserDetailViewModel(useCase)
    }

    @After
    fun tearDown() {
        confirmVerified(useCase)
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `when use case is invoke should set UserDetailUiState loading and success`() = runTest {
        val fakeUserDetailDomain = UserDetail(
            name = "name",
            avatarUrl = "avatarUrl",
            htmlUrl = "htmlUrl",
            location = "location",
            blogUrl = "blogUrl",
            publicRepos = 0,
            followers = 0,
            following = 0
        )
        val resultData = ResultData.Success(fakeUserDetailDomain)
        val fakeUserDetailPresentation = UserDetailPresentation(
            name = "name",
            avatarUrl = "avatarUrl",
            htmlUrl = "htmlUrl",
            location = "location",
            blogUrl = "blogUrl",
            publicRepos = 0,
            followers = 0,
            following = 0
        )
        val expected = UserDetailUiState.Success(fakeUserDetailPresentation)
        val results = mutableListOf<UserDetailUiState>()

        coEvery { useCase.invoke(any()) } coAnswers {
            delay(1000)
            resultData
        }

        viewModel.getUser("name")
        viewModel.uiState
            .take(2)
            .collect {
                results.add(it)
            }

        Assert.assertEquals(2, results.size)
        Assert.assertTrue(results[0] is UserDetailUiState.Loading)
        Assert.assertTrue(results[1] is UserDetailUiState.Success)
        Assert.assertEquals(expected, viewModel.uiState.value)
        coVerify(exactly = 1) { useCase.invoke("name") }
    }

    @Test
    fun `when use case is invoke should set UserDetailUiState loading and error`() = runTest {
        val error = Throwable("Error")
        val resultData = ResultData.Failure(error)
        val expected = UserDetailUiState.Error(error)
        val results = mutableListOf<UserDetailUiState>()

        coEvery { useCase.invoke(any()) } coAnswers {
            delay(1000)
            resultData
        }

        viewModel.getUser("name")
        viewModel.uiState
            .take(2)
            .collect {
                results.add(it)
            }

        Assert.assertEquals(2, results.size)
        Assert.assertTrue(results[0] is UserDetailUiState.Loading)
        Assert.assertTrue(results[1] is UserDetailUiState.Error)
        Assert.assertEquals(expected, viewModel.uiState.value)
        coVerify(exactly = 1) { useCase.invoke("name") }
    }
}