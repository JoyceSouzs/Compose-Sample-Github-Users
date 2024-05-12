package com.joysouza.compose.sample.github.user_details.data

import com.joysouza.compose.sample.github.features.user_detalis.data.UserDetailAPIService
import com.joysouza.compose.sample.github.features.user_detalis.data.UserDetailRemoteDataSourceImpl
import com.joysouza.compose.sample.github.features.user_detalis.data.UserDetailResponse
import com.joysouza.compose.sample.github.features.user_detalis.domain.UserDetailRemoteDataSource
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

class UserDetailRemoteDataTest {
    private val apiService = mockk<UserDetailAPIService>()
    private lateinit var remoteDataSource: UserDetailRemoteDataSource

    @Before
    fun setup() {
        remoteDataSource = UserDetailRemoteDataSourceImpl(apiService)
    }

    @After
    fun tearDown() {
        confirmVerified(apiService)
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `should return User detail when gets User Detail with htmlUrl requests call`() = runTest {
        val fakeUserDetail = UserDetailResponse(
            name = "name",
            avatarUrl = "avatarUrl",
            htmlUrl = "htmlUrl",
            location = "location",
            blogUrl = "blogUrl",
            publicRepos = 0,
            followers = 0,
            following = 0
        )

        val expected = "htmlUrl"

        coEvery { apiService.getUserDetail(any()) } returns fakeUserDetail

        val actual = remoteDataSource.getUserDetail("name")

        Assert.assertEquals(expected, actual.htmlUrl)

        coVerify(exactly = 1) {
            apiService.getUserDetail("name")
        }
    }
}