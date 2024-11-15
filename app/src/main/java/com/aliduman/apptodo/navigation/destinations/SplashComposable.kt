package com.aliduman.apptodo.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aliduman.apptodo.ui.screens.splash.SplashScreen
import com.aliduman.apptodo.util.Constants.SPLASH_SCREEN

fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit
) {
    composable(
        route = SPLASH_SCREEN,
    )
    {
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }

}
