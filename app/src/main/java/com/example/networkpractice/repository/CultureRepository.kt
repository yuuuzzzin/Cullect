package com.example.networkpractice.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.networkpractice.network.api.CultureService
import com.example.networkpractice.network.model.CultureModel
import com.example.networkpractice.repository.datasource.CultureByRealmDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CultureRepository
@Inject
constructor(private val cultureService: CultureService) {
    // suspend fun getCultureList() = cultureService.getCultureListByRealm()

    fun fetchCultureListByRealm(): Flow<PagingData<CultureModel>> {
        return Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { CultureByRealmDataSource(service = cultureService) }
        ).flow
    }
}