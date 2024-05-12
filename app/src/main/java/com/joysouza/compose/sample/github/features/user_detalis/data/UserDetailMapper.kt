package com.joysouza.compose.sample.github.features.user_detalis.data

import com.joysouza.compose.sample.github.features.user_detalis.domain.UserDetail as UserDetailDomain

fun UserDetailResponse.toUserDetailDomain() = UserDetailDomain(
    name = name,
    avatarUrl = avatarUrl,
    htmlUrl = htmlUrl,
    location = location,
    blogUrl = blogUrl,
    publicRepos = publicRepos,
    followers = followers,
    following = following
)
