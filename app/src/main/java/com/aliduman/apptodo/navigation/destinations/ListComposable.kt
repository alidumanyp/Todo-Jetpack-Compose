package com.aliduman.apptodo.navigation.destinations

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aliduman.apptodo.ui.screens.list.ListScreen
import com.aliduman.apptodo.ui.viewmodels.SharedViewModel
import com.aliduman.apptodo.util.Constants.LIST_ARGUMENT_KEY
import com.aliduman.apptodo.util.Constants.LIST_SCREEN
import com.aliduman.apptodo.util.toAction

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(
            navArgument(LIST_ARGUMENT_KEY) {
                type = NavType.StringType
                defaultValue =
                    "NO_ACTION" // Optional: provide a default to prevent missing argument issues
            }
        )
    )
    { navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()
        LaunchedEffect(key1 = action) {
            sharedViewModel.action.value = action
        }
        ListScreen(navigateToTaskScreen = navigateToTaskScreen, sharedViewModel = sharedViewModel)
    }


}
