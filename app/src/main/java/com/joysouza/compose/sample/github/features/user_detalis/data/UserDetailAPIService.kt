package com.joysouza.compose.sample.github.features.user_detalis.data

import com.joysouza.compose.sample.github.core.network.ApiEndpoints
import retrofit2.http.GET
import retrofit2.http.Path

interface UserDetailAPIService {
    @GET(ApiEndpoints.GET_USER)
    suspend fun getUserDetail(@Path("userLogin") userId: String): UserDetailResponse
}

