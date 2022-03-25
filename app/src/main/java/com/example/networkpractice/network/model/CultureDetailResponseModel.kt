package com.example.networkpractice.network.model

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "response")
data class CultureDetailResponseModel(
    @Element(name = "comMsgHeader")
    val header: Header,
    @Element(name = "msgBody")
    val body: DetailBody
)

@Xml(name = "msgBody")
data class DetailBody(
    @PropertyElement(name = "seq")
    val seq: String,
    @Element(name = "perforInfo")
    val cultureDetail: CultureDetailModel
)