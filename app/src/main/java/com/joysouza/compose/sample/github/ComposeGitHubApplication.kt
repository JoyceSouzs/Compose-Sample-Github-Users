package com.joysouza.compose.sample.github

import android.app.Application
import com.joysouza.compose.sample.github.core.network.NetworkModule
import com.joysouza.compose.sample.github.features.user_detalis.di.UserDetailModule
import com.joysouza.compose.sample.github.features.users.di.UsersModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ComposeGitHubApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ComposeGitHubApplication)
            modules(
                NetworkModule.module,
                UsersModule.module,
                UserDetailModule.module
            )
        }
    }
}
