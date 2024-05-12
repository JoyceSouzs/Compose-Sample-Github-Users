package com.joysouza.compose.sample.github.features.users.data

import com.joysouza.compose.sample.github.core.network.Endpoint
import retrofit2.http.GET

interface UsersAPIService {
    @GET(Endpoint.GET_USERS)
    suspend fun getUsers(): List<UserResponse>
}
