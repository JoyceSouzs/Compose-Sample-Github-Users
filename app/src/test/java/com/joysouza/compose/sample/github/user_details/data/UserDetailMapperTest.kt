package com.joysouza.compose.sample.github.user_details.data

import com.joysouza.compose.sample.github.features.user_detalis.data.UserDetailResponse
import com.joysouza.compose.sample.github.features.user_detalis.data.toUserDetailDomain
import com.joysouza.compose.sample.github.features.user_detalis.domain.UserDetail
import org.junit.Assert
import org.junit.Test

class UserDetailMapperTest {
    @Test
    fun `map UserDetailResponse to UserDetailDomain`() {
        val fakeUserDetail = UserDetailResponse(
            name = "name",
            avatarUrl = "avatarUrl",
            htmlUrl = "htmlUrl" ,
            location = "location",
            blogUrl = "blogUrl",
            publicRepos = 0,
            followers = 0,
            following = 0
        )
        val expected = UserDetail(
            name = "name",
            avatarUrl = "avatarUrl",
            htmlUrl = "htmlUrl" ,
            location = "location",
            blogUrl = "blogUrl",
            publicRepos = 0,
            followers = 0,
            following = 0
        )

        val actual = fakeUserDetail.toUserDetailDomain()

        Assert.assertEquals(expected, actual)
    }
}