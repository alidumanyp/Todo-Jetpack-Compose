package com.aliduman.apptodo.ui.screens.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.aliduman.apptodo.data.models.ToDoTask
import com.aliduman.apptodo.util.RequestState
import com.aliduman.apptodo.util.SearchAppBarState

@Composable
fun ListContent(
    allTasks: RequestState<List<ToDoTask>>,
    searchedTasks: RequestState<List<ToDoTask>>,
    navigateToTaskScreen: (taskId: Int) -> Unit,
    searchAppBarState: SearchAppBarState,
    paddingValues: PaddingValues
) {
    if (searchAppBarState == SearchAppBarState.TRIGGERED) {
        if (searchedTasks is RequestState.Success) {
            HandleListContent(
                tasks = searchedTasks.data,
                navigateToTaskScreen = navigateToTaskScreen,
                paddingValues = paddingValues
            )
        }
    } else {
        if (allTasks is RequestState.Success) {
            HandleListContent(
                tasks = allTasks.data,
                navigateToTaskScreen = navigateToTaskScreen,
                paddingValues = paddingValues
            )
        }
    }
}


@Composable
fun HandleListContent(
    tasks: List<ToDoTask>,
    navigateToTaskScreen: (taskId: Int) -> Unit,
    paddingValues: PaddingValues
) {
    if (tasks.isEmpty()) {
        EmptyContent()
        return // return early if the list is empty to avoid unnecessary recompositions
    } else {
        LazyColumn(
            contentPadding = paddingValues
        ) {
            items(
                items = tasks,
                key = { task ->
                    task.id
                }
            ) { task ->
                TaskItem(
                    toDoTask = task,
                    navigateToTaskScreen = navigateToTaskScreen
                )
            }
        }
    }

}
