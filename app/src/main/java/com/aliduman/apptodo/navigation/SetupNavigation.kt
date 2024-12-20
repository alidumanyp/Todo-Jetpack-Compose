package com.aliduman.apptodo.navigation

import Screens
import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.aliduman.apptodo.navigation.destinations.listComposable
import com.aliduman.apptodo.navigation.destinations.splashComposable
import com.aliduman.apptodo.navigation.destinations.taskComposable
import com.aliduman.apptodo.ui.viewmodels.SharedViewModel
import com.aliduman.apptodo.util.Constants.SPLASH_SCREEN

@SuppressLint("RememberReturnType")
@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN
    ) {
        splashComposable(
            navigateToListScreen = screen.splash
        )
        listComposable(
            navigateToTaskScreen = screen.list,
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            sharedViewModel = sharedViewModel,
            navigateToListScreen = screen.task
        )

    }

}