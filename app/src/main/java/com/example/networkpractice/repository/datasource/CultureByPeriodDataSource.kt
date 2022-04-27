package com.example.networkpractice.repository.datasource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.networkpractice.network.api.CultureService
import com.example.networkpractice.network.model.CultureModel
import javax.inject.Inject

class CultureByPeriodDataSource
@Inject
constructor(
    private val service: CultureService, private val from: String, private val to: String
) : PagingSource<Int, CultureModel>() {

    override fun getRefreshKey(state: PagingState<Int, CultureModel>): Int {
        return 0
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CultureModel> {
        return try {
            val page = params.key ?: 1
            val results = service.getCultureListByPeriod(
                page = page,
                from = from,
                to = to
            ).body!!.cultureList.toMutableList()
            Log.d("tag_d",results.toString())
            val nextPage = if (results.count() == 10) page + 1 else null
            LoadResult.Page(data = results, nextKey = nextPage, prevKey = null)
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }
}