package com.joysouza.compose.sample.github.users.data

import com.joysouza.compose.sample.github.features.users.data.UsersAPIService
import com.joysouza.compose.sample.github.features.users.data.UsersRemoteDataSourceImpl
import com.joysouza.compose.sample.github.features.users.data.UserResponse
import com.joysouza.compose.sample.github.features.users.domain.UsersRemoteDataSource
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

class UsersRemoteDataSourceTest {
    private val apiService = mockk<UsersAPIService>()
    private lateinit var remoteDataSource: UsersRemoteDataSource

    @Before
    fun setup() {
        remoteDataSource = UsersRemoteDataSourceImpl(apiService)
    }

    @After
    fun tearDown() {
        confirmVerified(apiService)
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `should return login User when gets users requests call`() = runTest {
        val fakeUser = listOf(
            UserResponse(
                login = "login",
                htmlUrl = "htmlUrl",
                avatarUrl = "avatarUrl"
            )
        )
        val expected = "login"

        coEvery { apiService.getUsers() } returns fakeUser
        val actual = remoteDataSource.getUsers()

        Assert.assertEquals(expected, actual[0].login)
        coVerify(exactly = 1) {
            apiService.getUsers()
        }
    }
}
