package com.example.codepairing.remote.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codepairing.remote.Repository.TempRepository
import com.example.codepairing.remote.Util.ApiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class TempViewModel @Inject constructor( private val tempRepository: TempRepository) : ViewModel() {

    private val postStateFlow: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)

    val _postStateFlow:StateFlow<ApiState> = postStateFlow

    fun getTemp() = viewModelScope.launch {
        postStateFlow.value = ApiState.Loading
        tempRepository.getTemp()
            .catch { e ->
                postStateFlow.value = ApiState.Failure(e)
            }.collect() {data ->
                postStateFlow.value = ApiState.Success(data)

            }
    }
}