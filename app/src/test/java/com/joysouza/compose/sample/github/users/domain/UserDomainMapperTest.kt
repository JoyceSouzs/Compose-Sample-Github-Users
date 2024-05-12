package com.joysouza.compose.sample.github.users.domain

import com.joysouza.compose.sample.github.features.users.domain.User
import com.joysouza.compose.sample.github.features.users.domain.toUserPresentation
import com.joysouza.compose.sample.github.features.users.presentation.User as UserPresentation
import org.junit.Assert
import org.junit.Test

class UserDomainMapperTest {
    @Test
    fun `map UserDomain to UserPresentation`() {
        val fakeUserDetail = User(
            login = "login",
            htmlUrl = "htmlUrl",
            avatarUrl = "avatarUrl"
        )
        val expected = UserPresentation(
            login = "login",
            htmlUrl = "htmlUrl",
            avatarUrl = "avatarUrl"
            )
        val actual = fakeUserDetail.toUserPresentation()

        Assert.assertEquals(expected, actual)
    }
}
