package com.joysouza.compose.sample.github.core.network

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    val module = module {
        single {
            Retrofit.Builder()
                .baseUrl(Endpoint.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
