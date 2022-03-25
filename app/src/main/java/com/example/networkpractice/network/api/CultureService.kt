package com.example.networkpractice.network.api

import com.example.networkpractice.network.model.CultureResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CultureService {

    // 분야별 공연, 전시 목록 조회
    @GET("realm")
    suspend fun getCultureListByRealm(
        //@Query("serviceKey") key: String = URLDecoder.decode("V6NrG18P1ouJ15RUK1gjBYWo%2Bn84PU33cLJ9ird2Zn8%2B8f3BGMG9SkTthepJHo5wreCTZiC5O69TjZAZnHGRIw%3D%3D", "UTF-8"),
        @Query("realmCode") realm: String = "A000",
        @Query("from") from: String = "20220303",
        @Query("to") to: String = "20221231",
        @Query("keyword") keyword: String?= null,
        @Query("cPage") page: Int = 1,
        @Query("rows") rows: Int = 10,
        @Query("sortStdr") sort: Int = 1
    ): CultureResponseModel

    // 기간별 공연, 전시 목록 조회
    @GET("period")
    suspend fun getCultureListByPeriod(): Response<CultureResponseModel>

    // 지역별 공연, 전시 목록 조회
    @GET("area")
    suspend fun getCultureListByArea(): Response<CultureResponseModel>
}