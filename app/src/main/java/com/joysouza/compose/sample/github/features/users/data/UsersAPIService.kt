package com.joysouza.compose.sample.github.features.users.data

import com.joysouza.compose.sample.github.core.network.ApiEndpoints
import retrofit2.http.GET

interface UsersAPIService {
    @GET(ApiEndpoints.GET_USERS)
    suspend fun getUsers(): List<UserResponse>
}
