package com.example.networkpractice.network.model

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml
data class CultureModel(
    @PropertyElement(name = "seq")
    val seq: String,
    @PropertyElement(name = "title")
    val title: String,
    @PropertyElement(name = "startDate")
    val startDate: String,
    @PropertyElement(name = "endDate")
    val endDate: String,
    @PropertyElement(name = "place")
    val place: String,
    @PropertyElement(name = "realmName")
    val realm: String,
    @PropertyElement(name = "area")
    val area: String?,
    @PropertyElement(name = "thumbnail")
    val thumbnail: String,
    @PropertyElement(name = "gpsX")
    val gpsX: String,
    @PropertyElement(name = "gpsY")
    val gpsY: String
)