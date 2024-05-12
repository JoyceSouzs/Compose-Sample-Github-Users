package com.joysouza.compose.sample.github.features.users.data

import com.joysouza.compose.sample.github.features.users.domain.User as UserDomain

fun UserResponse.toUserDomain() = UserDomain(
    login = login,
    avatarUrl = avatarUrl,
    htmlUrl = htmlUrl
)
