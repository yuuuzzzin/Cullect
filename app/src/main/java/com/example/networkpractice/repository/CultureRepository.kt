package com.example.networkpractice.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.networkpractice.model.CultureDetail
import com.example.networkpractice.model.Mapper.toCultureDetail
import com.example.networkpractice.network.api.CultureService
import com.example.networkpractice.network.model.CultureDetailModel
import com.example.networkpractice.network.model.CultureModel
import com.example.networkpractice.repository.datasource.CultureByPeriodDataSource
import com.example.networkpractice.repository.datasource.CultureByRealmDataSource
import com.example.networkpractice.util.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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

    fun getCultureDetail(seq: String): Flow<NetworkResult<CultureDetail>> = flow {

        delay(2000)

        val response = cultureService.getCultureDetail(seq)
        emit(
            when (response.isSuccessful) {
                // 응답이 성공적일 시
                true -> {
                    val detail = response.body()!!.body.cultureDetail
                    NetworkResult.Success(response.body())
                    response.body()?.let { it ->
                        NetworkResult.Success(it.body.cultureDetail.toCultureDetail())
                    } ?: NetworkResult.Error()
                }
                // 응답이 성공적이지 않을 시
                false -> NetworkResult.Error(response.code(), response.message())
            }
        )
    }
}