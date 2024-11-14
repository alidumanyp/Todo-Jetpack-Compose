package com.aliduman.apptodo.navigation.destinations

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aliduman.apptodo.ui.screens.task.TaskScreen
import com.aliduman.apptodo.ui.viewmodels.SharedViewModel
import com.aliduman.apptodo.util.Action
import com.aliduman.apptodo.util.Constants.TASK_ARGUMENT_KEY
import com.aliduman.apptodo.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments?.getInt(TASK_ARGUMENT_KEY) ?: -1

        LaunchedEffect(key1 = taskId) { // if taskId changes then get task from db and update selectedTask
            sharedViewModel.getSelectedTask(taskId = taskId)
        }

        val selectedTask by sharedViewModel.selectedTask.collectAsState() // observe selectedTask changes and update selectedTask value when it changes in db

        LaunchedEffect(key1 = selectedTask) {
            if (selectedTask != null || taskId == -1) { // if selectedTask is not null or taskId is -1 then navigate to list screen with no action and update task fields with selectedTask
                sharedViewModel.updateTaskFields(selectedTask = selectedTask)
            }

        }

        TaskScreen(
            navigateToListScreen = navigateToListScreen,
            selectedTask = selectedTask,
            sharedViewModel = sharedViewModel
        )
    }


}