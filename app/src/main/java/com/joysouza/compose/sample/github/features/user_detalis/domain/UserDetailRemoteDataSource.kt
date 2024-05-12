package com.joysouza.compose.sample.github.features.user_detalis.domain

import com.joysouza.compose.sample.github.features.user_detalis.data.UserDetailResponse

interface UserDetailRemoteDataSource {
    suspend fun getUserDetail(userId: String): UserDetailResponse
}
