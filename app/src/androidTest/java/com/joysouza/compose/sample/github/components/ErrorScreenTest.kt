package com.joysouza.compose.sample.github.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import com.joysouza.compose.sample.github.core.designsystem.components.ErrorScreen
import com.joysouza.compose.sample.github.core.designsystem.theme.ComposeSimpleGitHubTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ErrorScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            ComposeSimpleGitHubTheme {
                ErrorScreen(
                    onRetryClick = {}
                )
            }
        }
    }

    @Test
    fun errorScreenTest_currentLabelIsDisplayed() {
        composeTestRule.onNodeWithText("Algo deu errado...")
            .assertIsDisplayed()
    }

    @Test
    fun errorScreenTest_buttonIsDisplayedAndClick() {
        composeTestRule.onRoot().printToLog("currentLabelExists")
        composeTestRule.onNodeWithText("Tentar novamente")
            .assertIsDisplayed()
            .performClick()
    }
}
