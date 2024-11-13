package com.aliduman.apptodo.ui.screens.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.aliduman.apptodo.data.models.ToDoTask
import com.aliduman.apptodo.util.RequestState

@Composable
fun ListContent(
    tasks: RequestState<List<ToDoTask>>,
    navigateToTaskScreen: (taskId: Int) -> Unit,
    paddingValues: PaddingValues
) {
    if (tasks is RequestState.Success) {
        if (tasks.data.isEmpty()) {
            EmptyContent()
            return // return early if the list is empty to avoid unnecessary recompositions
        } else {
            LazyColumn(
                contentPadding = paddingValues
            ) {
                items(
                    items = tasks.data,
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
}


