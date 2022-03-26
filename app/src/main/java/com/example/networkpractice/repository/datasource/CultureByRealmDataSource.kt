package com.example.networkpractice.repository.datasource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.networkpractice.network.api.CultureService
import com.example.networkpractice.network.model.CultureModel
import timber.log.Timber
import javax.inject.Inject

class CultureByRealmDataSource
@Inject
constructor(private val service: CultureService
): PagingSource<Int, CultureModel>() {

    override fun getRefreshKey(state: PagingState<Int, CultureModel>): Int {
        return 0
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CultureModel> {
        return try {
            val page = params.key?: 1
            val results = service.getCultureListByRealm(page = page).body!!.cultureList.toMutableList()
            Log.d("tag_results", results.toString())
            val nextPage = if(results.count() == 10) page + 1 else null
            LoadResult.Page(data = results, nextKey = nextPage, prevKey = null)
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }
}