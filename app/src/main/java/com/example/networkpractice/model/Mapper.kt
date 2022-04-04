package com.example.networkpractice.model

import com.example.networkpractice.network.model.CultureDetailModel

/* Domain 계층에서는 Data 계층의 모델을 몰라야 하므로 Domain 계층의 모델로 바꿔주는 Mapper */

object Mapper {
    fun CultureDetailModel.toCultureDetail() = CultureDetail(
        seq, title, startDate, endDate, place, realm, area, price, url, phone, imgUrl, gpsX, gpsY
    )
}