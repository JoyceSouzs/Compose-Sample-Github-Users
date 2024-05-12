package com.joysouza.compose.sample.github.features.users.domain

import com.joysouza.compose.sample.github.features.users.data.UserResponse

interface UsersRemoteDataSource {
    suspend fun getUsers(): List<UserResponse>
}
