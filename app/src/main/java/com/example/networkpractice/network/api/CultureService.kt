package com.example.networkpractice.network.api

import com.example.networkpractice.network.model.CultureDetailResponseModel
import com.example.networkpractice.network.model.CultureResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CultureService {

    // 분야별 공연, 전시 목록 조회
    @GET("realm")
    suspend fun getCultureListByRealm(
        @Query("realmCode") realm: String = "A000",
        @Query("from") from: String?= "",
        @Query("to") to: String?= "",
        @Query("keyword") keyword: String?= null,
        @Query("cPage") page: Int = 1,
        @Query("rows") rows: Int = 10,
        @Query("sortStdr") sort: Int = 1
    ): CultureResponseModel

    // 기간별 공연, 전시 목록 조회
    @GET("period")
    suspend fun getCultureListByPeriod(
        @Query("from") from: String = "20220331",
        @Query("to") to: String = "20221231",
        @Query("keyword") keyword: String?= null,
        @Query("cPage") page: Int = 1,
        @Query("rows") rows: Int = 10,
        @Query("sortStdr") sort: Int = 1
    ): CultureResponseModel

    // 지역별 공연, 전시 목록 조회
    @GET("area")
    suspend fun getCultureListByArea(): Response<CultureResponseModel>

    // 공연, 전시 상세 조회
    @GET("d/")
    suspend fun getCultureDetail(
        @Query("seq") seq: String?= null
    ): Response<CultureDetailResponseModel>
}