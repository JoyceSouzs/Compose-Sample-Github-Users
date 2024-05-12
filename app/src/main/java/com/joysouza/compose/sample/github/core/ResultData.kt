package com.joysouza.compose.sample.github.core

sealed class ResultData<out R> {
    data class Success<out T>(val data: T) : ResultData<T>()
    data class Failure(val throwable: Throwable) : ResultData<Nothing>()
}
