package com.joysouza.compose.sample.github.features.user_detalis.data

import com.joysouza.compose.sample.github.core.network.Endpoint
import retrofit2.http.GET
import retrofit2.http.Path

interface UserDetailAPIService {
    @GET(Endpoint.GET_USER)
    suspend fun getUserDetail(@Path("userLogin") userId: String): UserDetailResponse
}

