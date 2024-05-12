package com.joysouza.compose.sample.github.features.users.data

import com.joysouza.compose.sample.github.core.ResultData
import com.joysouza.compose.sample.github.features.users.domain.User
import com.joysouza.compose.sample.github.features.users.domain.UsersRemoteDataSource
import com.joysouza.compose.sample.github.features.users.domain.UsersRepository

class UsersRepositoryImpl(
    private val remoteDataSource: UsersRemoteDataSource
) : UsersRepository {
    override suspend fun getUsers(): ResultData<List<User>> {
        return try {
            val result = remoteDataSource.getUsers().map {
                it.toUserDomain()
            }
            ResultData.Success(result)
        } catch (throwable: Throwable) {
            ResultData.Failure(throwable)
        }
    }
}
