package com.aliduman.apptodo.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aliduman.apptodo.data.models.ToDoTask
import com.aliduman.apptodo.data.repositories.ToDoRepository
import com.aliduman.apptodo.util.RequestState
import com.aliduman.apptodo.util.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ToDoRepository
) : ViewModel() {

    internal val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)
    internal val searchTextState: MutableState<String> = mutableStateOf("")


    private val _allTasks = MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Idle)
    val allTasks: StateFlow<RequestState<List<ToDoTask>>> = _allTasks


    fun getAllTasks() {
        _allTasks.value = RequestState.Loading
        try {
            viewModelScope.launch { // coroutine scope for viewModel
                repository.getAllTasks.collect {
                    _allTasks.value = RequestState.Success(it)
                }
            }

        } catch (e: Exception) {
            _allTasks.value = RequestState.Error(e)
        }

    }

}