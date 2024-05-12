package com.joysouza.compose.sample.github.user_details.data

import com.joysouza.compose.sample.github.core.ResultData
import com.joysouza.compose.sample.github.features.user_detalis.data.UserDetailRepositoryImpl
import com.joysouza.compose.sample.github.features.user_detalis.data.UserDetailResponse
import com.joysouza.compose.sample.github.features.user_detalis.domain.UserDetail
import com.joysouza.compose.sample.github.features.user_detalis.domain.UserDetailRemoteDataSource
import com.joysouza.compose.sample.github.features.user_detalis.domain.UserDetailRepository
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

class UserDetailRepositoryTest {
    private val remoteDataSource = mockk<UserDetailRemoteDataSource>()
    private lateinit var repository: UserDetailRepository

    @Before
    fun setup() {
        repository = UserDetailRepositoryImpl(remoteDataSource)
    }

    @After
    fun tearDown() {
        confirmVerified(remoteDataSource)
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `should return ResultData Success when get user detail requests call`() = runTest {
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
        val expected = ResultData.Success(fakeUserDetailDomain)

        coEvery { remoteDataSource.getUserDetail(any()) } returns fakeUserDetail
        val actual = repository.getUserDetail("name")

        Assert.assertEquals(expected, actual)
        coVerify(exactly = 1) {
            remoteDataSource.getUserDetail("name")
        }
    }

    @Test
    fun `should return ResultData Failure when get user detail requests call error`() = runTest {
        val error = Throwable("Error")
        val expected = ResultData.Failure(error)

        coEvery { remoteDataSource.getUserDetail(any()) } throws error
        val actual = repository.getUserDetail("name")

        Assert.assertEquals(expected, actual)
        coVerify(exactly = 1) {
            remoteDataSource.getUserDetail("name")
        }
    }
}
