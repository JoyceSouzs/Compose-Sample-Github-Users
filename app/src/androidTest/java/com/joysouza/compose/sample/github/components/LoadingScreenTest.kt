package com.joysouza.compose.sample.github.components

import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.joysouza.compose.sample.github.core.designsystem.components.LoadingScreen
import com.joysouza.compose.sample.github.core.designsystem.theme.ComposeSimpleGitHubTheme
import org.junit.Rule
import org.junit.Test

class LoadingScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loadingScreenTest_currentLabelExists() {
        composeTestRule.setContent {
            ComposeSimpleGitHubTheme {
                LoadingScreen()
            }
        }

        composeTestRule.onNodeWithContentDescription(
            "Indicador de progresso"
        ).assertExists()

        composeTestRule.onNodeWithText("Por favor aguarde…")
            .assertExists()
            .isDisplayed()
    }

    @Test
    fun loadingScreenTest_withMessageCurrentLabelExists() {
        composeTestRule.setContent {
            ComposeSimpleGitHubTheme {
                LoadingScreen("Aguarde!!")
            }
        }

        composeTestRule.onRoot().printToLog("currentLabelExists")
        composeTestRule.onNodeWithContentDescription(
            "Indicador de progresso"
        ).assertExists()

        composeTestRule.onNodeWithText("Aguarde!!")
            .assertExists()
            .isDisplayed()
    }
}
