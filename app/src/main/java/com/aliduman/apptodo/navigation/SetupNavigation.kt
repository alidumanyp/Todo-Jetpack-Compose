package com.aliduman.apptodo.navigation

import Screens
import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.aliduman.apptodo.navigation.destinations.listComposable
import com.aliduman.apptodo.navigation.destinations.taskComposable
import com.aliduman.apptodo.util.Constants.LIST_SCREEN

@SuppressLint("RememberReturnType")
@Composable
fun SetupNavigation(
    navController: NavHostController
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(navController = navController, startDestination = LIST_SCREEN) {
        listComposable(
            navigateToTaskScreen = screen.task
        )
        taskComposable(
            navigateToListScreen = screen.list
        )

    }

}