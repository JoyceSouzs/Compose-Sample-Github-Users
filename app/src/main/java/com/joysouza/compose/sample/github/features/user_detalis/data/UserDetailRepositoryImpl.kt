package com.joysouza.compose.sample.github.features.user_detalis.data

import com.joysouza.compose.sample.github.core.ResultData
import com.joysouza.compose.sample.github.features.user_detalis.domain.UserDetail
import com.joysouza.compose.sample.github.features.user_detalis.domain.UserDetailRemoteDataSource
import com.joysouza.compose.sample.github.features.user_detalis.domain.UserDetailRepository

class UserDetailRepositoryImpl(
    private val remoteDataSource: UserDetailRemoteDataSource,
) : UserDetailRepository {
    override suspend fun getUserDetail(userLogin: String): ResultData<UserDetail> {
        return try {
            val result = remoteDataSource.getUserDetail(userLogin).toUserDetailDomain()
            ResultData.Success(result)
        } catch (throwable: Throwable) {
            ResultData.Failure(throwable)
        }
    }
}
