package com.joysouza.compose.sample.github.features.users.domain

import com.joysouza.compose.sample.github.core.ResultData

interface UsersRepository {
    suspend fun getUsers(): ResultData<List<User>>
}
