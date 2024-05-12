package com.joysouza.compose.sample.github.users.data

import com.joysouza.compose.sample.github.core.ResultData
import com.joysouza.compose.sample.github.features.users.data.UserResponse
import com.joysouza.compose.sample.github.features.users.data.UsersRepositoryImpl
import com.joysouza.compose.sample.github.features.users.domain.User
import com.joysouza.compose.sample.github.features.users.domain.UsersRemoteDataSource
import com.joysouza.compose.sample.github.features.users.domain.UsersRepository
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UsersRepositoryTest {
    private val remoteDataSource = mockk<UsersRemoteDataSource>()
    private lateinit var repository: UsersRepository

    @Before
    fun setup() {
        repository = UsersRepositoryImpl(remoteDataSource)
    }

    @After
    fun tearDown() {
        confirmVerified(remoteDataSource)
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `should return ResultData Success when get Users requests call`() {
        val fakeUser = listOf(
            UserResponse(
                login = "login",
                htmlUrl = "htmlUrl",
                avatarUrl = "avatarUrl"
            )
        )
        val fakeUserDomain = listOf(
            User(
                login = "login",
                htmlUrl = "htmlUrl",
                avatarUrl = "avatarUrl"
            )
        )
        val expected = ResultData.Success(fakeUserDomain)

        coEvery { remoteDataSource.getUsers() } returns fakeUser
        runTest {
            val actual = repository.getUsers()
            Assert.assertEquals(expected, actual)
        }

        coVerify(exactly = 1) {
            remoteDataSource.getUsers()
        }
    }

    @Test
    fun `should return ResultData Failure when get Users requests call error`() {
        val error = Throwable("Error")
        val expected = ResultData.Failure(error)

        coEvery { remoteDataSource.getUsers() } throws error
        runTest {
            val actual = repository.getUsers()
            Assert.assertEquals(expected, actual)
        }

        coVerify(exactly = 1) {
            remoteDataSource.getUsers()
        }
    }
}
