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
    @PropertyElement(name = "realmName")
    val realm: String,
    @PropertyElement(name = "area")
    val area: String?,
    @PropertyElement(name = "subTitle")
    val subTitle: String?,
    @PropertyElement(name = "price")
    val price: String?,
    @PropertyElement(name = "contents1")
    val contents1: String?,
    @PropertyElement(name = "contents2")
    val contents2: String?,
    @PropertyElement(name = "url")
    val url: String?,
    @PropertyElement(name = "phone")
    val phone: String?,
    @PropertyElement(name = "imgUrl")
    val imgUrl: String?,
    @PropertyElement(name = "gpsX")
    val gpsX: String,
    @PropertyElement(name = "gpsY")
    val gpsY: String,
    @PropertyElement(name = "placeUrl")
    val placeUrl: String?,
    @PropertyElement(name = "placeAddr")
    val placeAddress: String?,
    @PropertyElement(name = "placeSeq")
    val placeSeq: String
)