package com.joysouza.compose.sample.github.navigation

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.joysouza.compose.sample.github.core.navigation.UsersRoutes
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AppNavHostTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController

    @Before
    fun setup() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            AppNavHost(navController = navController)
        }
    }

    @Test
    fun appNavHost_verifyUsersScreenStartDestinationToLoadingScreen() {
        composeTestRule.onNodeWithText("Por favor aguarde…")
            .assertExists()
            .isDisplayed()
    }

    @Test
    fun appNavHost_clickUser_navigateToUserDetail() {
        composeTestRule.onAllNodesWithContentDescription("Info usuário")[0]
            .assertExists()
            .performClick()

        val route = navController.currentBackStackEntry?.destination?.route
        Assert.assertEquals(route, UsersRoutes.USERS_DETAIL)
    }
}