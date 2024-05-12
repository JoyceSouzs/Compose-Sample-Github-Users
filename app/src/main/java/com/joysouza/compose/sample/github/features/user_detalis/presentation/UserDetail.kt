package com.joysouza.compose.sample.github.features.user_detalis.presentation

data class UserDetail(
    val name: String,
    val avatarUrl: String,
    val htmlUrl: String,
    val location: String?,
    val blogUrl: String,
    val publicRepos: Int,
    val followers: Int,
    val following: Int,
)
