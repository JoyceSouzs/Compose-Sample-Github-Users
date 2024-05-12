package com.joysouza.compose.sample.github.features.user_detalis.domain

import com.joysouza.compose.sample.github.core.ResultData

interface GetUserDetailUseCase {
    suspend operator fun invoke(userLogin: String): ResultData<UserDetail>
}

class GetUserDetailUseCaseImpl(
    private val userDetailRepositoy: UserDetailRepository
) : GetUserDetailUseCase {
    override suspend fun invoke(userLogin: String): ResultData<UserDetail> {
        return userDetailRepositoy.getUserDetail(userLogin)
    }
}
