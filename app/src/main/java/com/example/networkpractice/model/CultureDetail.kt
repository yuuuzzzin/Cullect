package com.example.networkpractice.model

data class CultureDetail(
    val seq: String,
    val title: String,
    val startDate: String,
    val endDate: String,
    val place: String?,
    val realm: String,
    val area: String?,
    val price: String?,
    val url: String?,
    val phone: String?,
    val imgUrl: String?,
    val gpsX: String,
    val gpsY: String,
)
