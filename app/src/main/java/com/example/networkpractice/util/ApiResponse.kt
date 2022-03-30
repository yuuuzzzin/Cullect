package com.example.networkpractice.util

sealed class ApiResponse<out T> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val exception: Throwable? = null): ApiResponse<Nothing>()
    object Empty: ApiResponse<Nothing>()
}