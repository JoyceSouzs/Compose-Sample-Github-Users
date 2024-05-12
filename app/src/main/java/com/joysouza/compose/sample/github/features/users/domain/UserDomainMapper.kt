package com.joysouza.compose.sample.github.features.users.domain

import com.joysouza.compose.sample.github.features.users.presentation.User as UserPresentation

fun User.toUserPresentation() = UserPresentation(
    login = login,
    avatarUrl = avatarUrl,
    htmlUrl = htmlUrl
)
