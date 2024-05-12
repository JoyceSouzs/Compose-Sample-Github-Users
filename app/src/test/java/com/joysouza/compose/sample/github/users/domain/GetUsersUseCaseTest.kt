package com.joysouza.compose.sample.github.users.domain

import com.joysouza.compose.sample.github.core.ResultData
import com.joysouza.compose.sample.github.features.users.domain.GetUsersUseCase
import com.joysouza.compose.sample.github.features.users.domain.GetUsersUseCaseImpl
import com.joysouza.compose.sample.github.features.users.domain.User
import com.joysouza.compose.sample.github.features.users.domain.UsersRepository
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetUsersUseCaseTest {
    private val repository = mockk<UsersRepository>()
    private lateinit var useCase: GetUsersUseCase

    @Before
    fun setup() {
        useCase = GetUsersUseCaseImpl(repository)
    }

    @After
    fun tearDown() {
        confirmVerified(repository)
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `should return ResultData Success when use case is invoke`() = runBlocking {
        val fakeUserDomain = listOf(
            User(
                login = "login",
                htmlUrl = "htmlUrl",
                avatarUrl = "avatarUrl"
            )
        )
        val expected = ResultData.Success(fakeUserDomain)

        coEvery { repository.getUsers() } returns expected
        val actual = useCase.invoke()

        Assert.assertEquals(expected, actual)
        coVerify(exactly = 1) {
            repository.getUsers()
        }
    }
}
