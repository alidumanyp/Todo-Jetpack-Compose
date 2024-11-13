package com.aliduman.apptodo.ui.screens.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aliduman.apptodo.components.PriorityDropDown
import com.aliduman.apptodo.data.models.Priority
import com.aliduman.apptodo.ui.theme.LARGE_PADDING

@Composable
fun TaskContent(
    paddingValues: PaddingValues,
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(all = LARGE_PADDING)
            .padding(paddingValues)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(bottom = LARGE_PADDING),
            value = title,
            onValueChange = { onTitleChange(it) },
            label = { Text(text = "Title") },
            textStyle = MaterialTheme.typography.bodyMedium,
            singleLine = true
        )
        PriorityDropDown(priority = priority, onPrioritySelected = onPrioritySelected)
        OutlinedTextField(
            modifier = Modifier.fillMaxSize().padding(top = LARGE_PADDING),
            value = description,
            onValueChange = { onDescriptionChange(it) },
            label = { Text(text = "Description") },
            textStyle = MaterialTheme.typography.bodyMedium,
        )

    }

}