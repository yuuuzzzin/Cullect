package com.example.networkpractice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.networkpractice.network.model.CultureModel
import com.example.networkpractice.repository.CultureRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private val repository: CultureRepository
) : ViewModel() {

    fun fetchCultureListByRealm(): Flow<PagingData<CultureModel>> {
        return repository.fetchCultureListByRealm()
    }

}