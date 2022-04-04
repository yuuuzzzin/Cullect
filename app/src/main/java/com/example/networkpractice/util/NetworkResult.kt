package com.example.networkpractice.util

/* API 통신 결과를 다루기 위한 sealed class */

sealed class NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>() // 성공
    data class Error(val code: Int? = null, val msg: String? = null) : NetworkResult<Nothing>() // 실패
}