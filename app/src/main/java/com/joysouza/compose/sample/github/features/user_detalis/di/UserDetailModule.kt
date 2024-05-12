package com.joysouza.compose.sample.github.features.user_detalis.di

import com.joysouza.compose.sample.github.features.user_detalis.data.UserDetailAPIService
import com.joysouza.compose.sample.github.features.user_detalis.data.UserDetailRemoteDataSourceImpl
import com.joysouza.compose.sample.github.features.user_detalis.data.UserDetailRepositoryImpl
import com.joysouza.compose.sample.github.features.user_detalis.domain.GetUserDetailUseCase
import com.joysouza.compose.sample.github.features.user_detalis.domain.GetUserDetailUseCaseImpl
import com.joysouza.compose.sample.github.features.user_detalis.domain.UserDetailRemoteDataSource
import com.joysouza.compose.sample.github.features.user_detalis.domain.UserDetailRepository
import com.joysouza.compose.sample.github.features.user_detalis.presentation.UserDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

object UserDetailModule {
    val module = module {
        single {
            get<Retrofit>().create(
                UserDetailAPIService::class.java
            )
        }
        single<UserDetailRemoteDataSource> {
            UserDetailRemoteDataSourceImpl(
                service = get()
            )
        }
        single<UserDetailRepository> {
            UserDetailRepositoryImpl(
                remoteDataSource = get()
            )
        }
        single<GetUserDetailUseCase> {
            GetUserDetailUseCaseImpl(
                userDetailRepositoy = get()
            )
        }
        viewModel { UserDetailViewModel(get()) }
    }
}