package com.example.networkpractice.network.model

import android.graphics.ImageDecoder
import android.net.Uri
import com.example.networkpractice.model.CultureList
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "response")
data class CultureResponseModel(
    @Element(name = "comMsgHeader")
    val header: Header?,
    @Element(name = "msgBody")
    val body: Body?
)
//    : BaseResponse<CultureList> () {
//    override fun mapper(): CultureList {
//        return CultureList(
//            cultureList = body!!.cultureList
//        )
//    }
//}

@Xml(name = "comMsgHeader")
data class Header(
    @PropertyElement(name = "RequestMsgID")
    val requestMsgId: String?,
    @PropertyElement(name = "ResponseTime")
    val time: String,
    @PropertyElement(name = "ResponseMsgID")
    val responseMsgId: String?,
    @PropertyElement(name = "SuccessYN")
    val success: String,
    @PropertyElement(name = "ReturnCode")
    val code: String,
    @PropertyElement(name = "ErrMsg")
    val message: String
)

@Xml(name = "msgBody")
data class Body(
    @PropertyElement(name = "totalCount")
    val totalCnt: Int,
    @PropertyElement(name = "cPage")
    val page: Int,
    @PropertyElement(name = "rows")
    val rows: Int,
    @PropertyElement(name = "realmCode")
    val realm: String,
    @PropertyElement(name = "from")
    val from: String,
    @PropertyElement(name = "to")
    val to: String,
    @PropertyElement(name = "keyword")
    val keyword: String?,
    @PropertyElement(name = "sortStdr")
    val sort: Int,
    @Element(name = "perforList")
    val cultureList: List<CultureModel>
)