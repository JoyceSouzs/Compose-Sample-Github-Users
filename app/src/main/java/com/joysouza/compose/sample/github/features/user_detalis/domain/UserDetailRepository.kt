package com.joysouza.compose.sample.github.features.user_detalis.domain

import com.joysouza.compose.sample.github.core.ResultData

interface UserDetailRepository {
    suspend fun getUserDetail(userLogin: String): ResultData<UserDetail>
}
