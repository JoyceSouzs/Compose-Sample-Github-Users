package com.joysouza.compose.sample.github.features.users.data

import com.joysouza.compose.sample.github.features.users.domain.UsersRemoteDataSource

class UsersRemoteDataSourceImpl(
    private val service: UsersAPIService
) : UsersRemoteDataSource {
    override suspend fun getUsers(): List<UserResponse> {
        return service.getUsers()
    }
}
