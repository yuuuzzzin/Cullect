package com.example.networkpractice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkpractice.network.model.CultureDetailModel
import com.example.networkpractice.repository.CultureRepository
import com.example.networkpractice.util.ApiResponse
import com.example.networkpractice.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel
@Inject
constructor(
    private val repository: CultureRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<CultureDetailModel>>(UiState.Loading)
    val uiState: StateFlow<UiState<CultureDetailModel>> = _uiState.asStateFlow()

    fun getCultureDetail(seq: String) {
        viewModelScope.launch {
            repository.getCultureDetail(seq).collectLatest { response ->
                when (response) {
                    is ApiResponse.Success -> {
                        _uiState.emit(UiState.Success(response.data))
                    }
                    is ApiResponse.Empty -> {
                        _uiState.emit(UiState.Empty)
                    }
                    is ApiResponse.Error -> {
                        _uiState.emit(UiState.Error(response.exception))
                    }
                }
            }
        }
    }
}