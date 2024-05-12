package com.joysouza.compose.sample.github.user_details.domain

import com.joysouza.compose.sample.github.core.ResultData
import com.joysouza.compose.sample.github.features.user_detalis.domain.GetUserDetailUseCase
import com.joysouza.compose.sample.github.features.user_detalis.domain.GetUserDetailUseCaseImpl
import com.joysouza.compose.sample.github.features.user_detalis.domain.UserDetail
import com.joysouza.compose.sample.github.features.user_detalis.domain.UserDetailRepository
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

class GetUserDetailUseCaseTest {
    private val repository = mockk<UserDetailRepository>()
    private lateinit var useCase: GetUserDetailUseCase

    @Before
    fun setup() {
        useCase = GetUserDetailUseCaseImpl(repository)
    }

    @After
    fun tearDown() {
        confirmVerified(repository)
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `should return ResultData Success when use case is invoke`() = runBlocking {
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

        coEvery { repository.getUserDetail(any()) } returns expected
        val actual = useCase.invoke("name")

        Assert.assertEquals(expected, actual)
        coVerify(exactly = 1) {
            repository.getUserDetail(any())
        }
    }
}
