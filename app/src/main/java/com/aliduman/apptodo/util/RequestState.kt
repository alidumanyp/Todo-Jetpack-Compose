package com.aliduman.apptodo.util

sealed class RequestState<out T> {
    data object Idle: RequestState<Nothing>()
    data object Loading: RequestState<Nothing>()
    data class Success<T>(val data: T): RequestState<T>()
    data class Error(val error: Throwable): RequestState<Nothing>()
}

// sealed class for handling network requests
// like loading, success, error and idle states of the app