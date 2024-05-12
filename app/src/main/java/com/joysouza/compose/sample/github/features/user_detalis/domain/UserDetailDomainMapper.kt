package com.joysouza.compose.sample.github.features.user_detalis.domain

import com.joysouza.compose.sample.github.features.user_detalis.presentation.UserDetail as UserDetailPresentation

fun UserDetail.toUserDetailPresentation() = UserDetailPresentation(
    name = name,
    avatarUrl = avatarUrl,
    htmlUrl = htmlUrl,
    location = location,
    blogUrl = blogUrl,
    publicRepos = publicRepos,
    followers = followers,
    following = following
)
