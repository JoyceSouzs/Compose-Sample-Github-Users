package com.joysouza.compose.sample.github

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import com.joysouza.compose.sample.github.core.designsystem.theme.ComposeSimpleGitHubTheme
import com.joysouza.compose.sample.github.features.users.presentation.User
import com.joysouza.compose.sample.github.features.users.presentation.UserItem
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val fakeUser = User(
        login = "login",
        htmlUrl = "htmlUrl",
        avatarUrl = "avatarUrl"
    )

    @Before
    fun setup() {
        composeTestRule.setContent {
            ComposeSimpleGitHubTheme {
                UserItem(
                    user = fakeUser,
                    {}
                )
            }
        }
    }

    @Test
    fun userItemTest_favoriteLabelIsDisplayedAndClick() {
        composeTestRule.onRoot().printToLog("currentLabelExists")
        composeTestRule.onNodeWithContentDescription("Favorito")
            .assertIsDisplayed()
            .performClick()
    }

    @Test
    fun userItemTest_imageLabelExists() {
        composeTestRule.onNodeWithContentDescription("Imagem do usuário")
            .assertExists()
    }
}