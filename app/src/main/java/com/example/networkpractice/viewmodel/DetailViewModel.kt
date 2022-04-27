package com.example.networkpractice.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkpractice.model.CultureDetail
import com.example.networkpractice.repository.CultureRepository
import com.example.networkpractice.ui.detail.DetailActivity
import com.example.networkpractice.util.NetworkResult
import com.example.networkpractice.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DetailViewModel
@Inject
constructor(
    repository: CultureRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val seq: String = savedStateHandle.get(DetailActivity.CULTURE_SEQ)
        ?: throw IllegalStateException("There is no value of the culture seq.")

    // Ui 상태 값 (초깃값: 로딩 상태)
    val uiState: StateFlow<UiState<CultureDetail>> =
            repository.getCultureDetail(seq)
        .map { result -> // 네트워크 결과 값에 따른 UiState 값 처리
            when (result) {
                is NetworkResult.Success -> {
                    UiState.Success(result.data)
                }
                is NetworkResult.Error -> {
                    UiState.Error(result.code, result.msg)
                }
            }
        }.stateIn( // Flow를 StateFlow로 변환
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = UiState.Loading
        )
}