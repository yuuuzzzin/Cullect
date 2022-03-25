package com.example.networkpractice.network.model

abstract class BaseResponse<M> {
    abstract fun mapper(): M
}