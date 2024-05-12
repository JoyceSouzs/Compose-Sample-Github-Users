package com.joysouza.compose.sample.github.features.users.domain

import com.joysouza.compose.sample.github.core.ResultData

interface GetUsersUseCase {
    suspend operator fun invoke(): ResultData<List<User>>
}

class GetUsersUseCaseImpl(
    private val usersRepositoy: UsersRepository
) : GetUsersUseCase {
    override suspend fun invoke(): ResultData<List<User>> {
        return usersRepositoy.getUsers()
    }
}
