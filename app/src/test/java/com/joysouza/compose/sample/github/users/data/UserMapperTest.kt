package com.joysouza.compose.sample.github.users.data

import com.joysouza.compose.sample.github.features.users.data.UserResponse
import com.joysouza.compose.sample.github.features.users.data.toUserDomain
import com.joysouza.compose.sample.github.features.users.domain.User as UserDomain
import org.junit.Assert
import org.junit.Test

class UserMapperTest {
    @Test
    fun `map UserResponse to UserDomain`() {
        val fakeUser = UserResponse(
            login = "login",
            htmlUrl = "htmlUrl",
            avatarUrl = "avatarUrl"
        )
        val expected = UserDomain(
            login = "login",
            htmlUrl = "htmlUrl",
            avatarUrl = "avatarUrl"
        )
        val actual = fakeUser.toUserDomain()

        Assert.assertEquals(expected, actual)
    }
}
