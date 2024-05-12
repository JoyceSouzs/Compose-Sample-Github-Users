package com.joysouza.compose.sample.github.features.users.di

import com.joysouza.compose.sample.github.features.users.data.UsersAPIService
import com.joysouza.compose.sample.github.features.users.data.UsersRemoteDataSourceImpl
import com.joysouza.compose.sample.github.features.users.data.UsersRepositoryImpl
import com.joysouza.compose.sample.github.features.users.domain.GetUsersUseCase
import com.joysouza.compose.sample.github.features.users.domain.GetUsersUseCaseImpl
import com.joysouza.compose.sample.github.features.users.domain.UsersRemoteDataSource
import com.joysouza.compose.sample.github.features.users.domain.UsersRepository
import com.joysouza.compose.sample.github.features.users.presentation.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

object UsersModule {
    val module = module {
        single {
            get<Retrofit>().create(
                UsersAPIService::class.java
            )
        }
        single<UsersRemoteDataSource> {
            UsersRemoteDataSourceImpl(
                service = get()
            )
        }
        single<UsersRepository> {
            UsersRepositoryImpl(
                remoteDataSource = get()
            )
        }
        single<GetUsersUseCase> {
            GetUsersUseCaseImpl(
                usersRepositoy = get()
            )
        }
        viewModel { UsersViewModel(get()) }
    }
}
