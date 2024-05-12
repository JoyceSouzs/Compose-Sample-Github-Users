package com.joysouza.compose.sample.github.features.user_detalis.data

import com.joysouza.compose.sample.github.features.user_detalis.domain.UserDetailRemoteDataSource

class UserDetailRemoteDataSourceImpl(
    private val service: UserDetailAPIService
) : UserDetailRemoteDataSource {
    override suspend fun getUserDetail(userId: String): UserDetailResponse {
        return service.getUserDetail(userId)
    }
}
