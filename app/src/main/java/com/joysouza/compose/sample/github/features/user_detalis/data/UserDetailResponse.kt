package com.joysouza.compose.sample.github.features.user_detalis.data

import com.google.gson.annotations.SerializedName

data class UserDetailResponse(
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("name") val name: String,
    @SerializedName("location") val location: String,
    @SerializedName("blog") val blogUrl: String,
    @SerializedName("public_repos") val publicRepos: Int,
    @SerializedName("followers") val followers: Int,
    @SerializedName("following") val following: Int,
)
