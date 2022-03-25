package com.example.networkpractice.network.model

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "msgBody")
data class CultureDetailModel(
    @PropertyElement(name = "seq")
    val seq: String,
    @PropertyElement(name = "title")
    val title: String,
    @PropertyElement(name = "startDate")
    val startDate: String,
    @PropertyElement(name = "endDate")
    val endDate: String,
    @PropertyElement(name = "place")
    val place: String?,
    @PropertyElement(name = "reralmName")
    val to: String,
    @PropertyElement(name = "area")
    val keyword: String?,
    @PropertyElement(name = "subTitle")
    val sortStdr: Int
)