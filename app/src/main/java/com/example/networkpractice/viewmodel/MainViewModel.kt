package com.example.networkpractice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.networkpractice.network.model.CultureModel
import com.example.networkpractice.repository.CultureRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val repository: CultureRepository
) : ViewModel() {

    fun fetchCultureListByPeriod(from: String, to: String): Flow<PagingData<CultureModel>> {
        return repository.fetchCultureListByPeriod(from, to)
    }

    fun fetchCultureListByRealm(realm: String): Flow<PagingData<CultureModel>> {
        return repository.fetchCultureListByRealm(realm)
    }
}