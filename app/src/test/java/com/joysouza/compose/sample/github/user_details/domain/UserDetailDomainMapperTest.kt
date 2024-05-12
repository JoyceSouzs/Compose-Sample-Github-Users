package com.joysouza.compose.sample.github.user_details.domain

import com.joysouza.compose.sample.github.features.user_detalis.domain.UserDetail
import com.joysouza.compose.sample.github.features.user_detalis.domain.toUserDetailPresentation
import com.joysouza.compose.sample.github.features.user_detalis.presentation.UserDetail as UserDetailPresentation
import org.junit.Assert
import org.junit.Test

class UserDetailDomainMapperTest {
    @Test
    fun `map UserDetailDomain to UserDetailPresentation`() {
        val fakeUserDetail = UserDetail(
            name = "name",
            avatarUrl = "avatarUrl",
            htmlUrl = "htmlUrl" ,
            location = "location",
            blogUrl = "blogUrl",
            publicRepos = 0,
            followers = 0,
            following = 0
        )
        val expected = UserDetailPresentation(
            name = "name",
            avatarUrl = "avatarUrl",
            htmlUrl = "htmlUrl" ,
            location = "location",
            blogUrl = "blogUrl",
            publicRepos = 0,
            followers = 0,
            following = 0
        )
        val actual = fakeUserDetail.toUserDetailPresentation()

        Assert.assertEquals(expected, actual)
    }
}
