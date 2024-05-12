package com.joysouza.compose.sample.github.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.joysouza.compose.sample.github.core.designsystem.components.HomeScreen
import com.joysouza.compose.sample.github.core.designsystem.theme.ComposeSimpleGitHubTheme
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun homeScreenTest_currentLabelIsDisplayed() {
        composeTestRule.setContent {
            ComposeSimpleGitHubTheme {
                HomeScreen()
            }
        }

        composeTestRule.onNodeWithText("GitHub Usuários").assertIsDisplayed()
    }
}
