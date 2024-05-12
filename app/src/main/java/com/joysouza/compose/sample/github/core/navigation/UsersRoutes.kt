package com.joysouza.compose.sample.github.core.navigation

import androidx.navigation.NavController

object UsersRoutes {
    const val USER_LOGIN = "user-login"
    const val USERS = "users"
    const val USERS_DETAIL = "$USERS/{$USER_LOGIN}"
}

fun NavController.navigateToUsersDetail(userLogin: String) {
    navigate(route = "${UsersRoutes.USERS}/$userLogin")
}
