package com.joysouza.compose.sample.github.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.joysouza.compose.sample.github.core.designsystem.components.HomeScreen
import com.joysouza.compose.sample.github.core.navigation.UsersRoutes
import com.joysouza.compose.sample.github.core.navigation.navigateToUsersDetail
import com.joysouza.compose.sample.github.features.user_detalis.presentation.UsersDetailScreen
import com.joysouza.compose.sample.github.features.users.presentation.UsersScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = UsersRoutes.USERS
    ) {
        composable(
            route = UsersRoutes.USERS
        ) {
            HomeScreen(
                content = {
                    UsersScreen(
                        navigateToDetail = { userLogin ->
                            navController.navigateToUsersDetail(userLogin)
                        }
                    )
                }
            )
        }
        composable(
            route = UsersRoutes.USERS_DETAIL,
            arguments = listOf(
                navArgument(
                    name = UsersRoutes.USER_LOGIN
                ) {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            val userLoginType =
                navBackStackEntry.arguments?.getString(UsersRoutes.USER_LOGIN)
            if (userLoginType != null) {
                UsersDetailScreen(
                    userLogin = userLoginType,
                    onBackButtonClicked = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
