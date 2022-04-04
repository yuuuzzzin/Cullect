package com.example.networkpractice.util

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Success<out T>(val data: T) : UiState<T>()
    data class Error(val code: Int? = null, val msg: String? = null): UiState<Nothing>()
}