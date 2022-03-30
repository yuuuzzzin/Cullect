package com.example.networkpractice.util

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Success<out T>(val data: T) : UiState<T>()
    data class Error(val error: Throwable? = null): UiState<Nothing>()
    object Empty: UiState<Nothing>()
}