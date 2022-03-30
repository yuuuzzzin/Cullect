package com.example.networkpractice.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.networkpractice.network.api.CultureService
import com.example.networkpractice.network.model.CultureDetailModel
import com.example.networkpractice.network.model.CultureModel
import com.example.networkpractice.repository.datasource.CultureByPeriodDataSource
import com.example.networkpractice.repository.datasource.CultureByRealmDataSource
import com.example.networkpractice.util.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CultureRepository
@Inject
constructor(private val cultureService: CultureService) {

    fun fetchCultureListByRealm(realm: String): Flow<PagingData<CultureModel>> {
        return Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { CultureByRealmDataSource(service = cultureService, realm = realm) }
        ).flow
    }

    fun fetchCultureListByPeriod(from: String, to: String): Flow<PagingData<CultureModel>> {
        return Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { CultureByPeriodDataSource(service = cultureService, from = from, to = to) }
        ).flow
    }

    fun getCultureDetail(seq: String): Flow<ApiResponse<CultureDetailModel>> = flow {

        delay(500L)

        val response = cultureService.getCultureDetail(seq)
        if (response.isSuccessful) {
            val detail = response.body()!!.body.cultureDetail
            emit(ApiResponse.Success(detail))
        } else {
            throw Exception("[${response.code()}] - ${response.raw()}")
        }
    }
        .catch { ApiResponse.Error(it) }
        .flowOn(Dispatchers.IO)


}