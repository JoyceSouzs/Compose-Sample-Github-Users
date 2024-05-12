package com.joysouza.compose.sample.github.features.users.data

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("login") val login: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("html_url") val htmlUrl: String
)
