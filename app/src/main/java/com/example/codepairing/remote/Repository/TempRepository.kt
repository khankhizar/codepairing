package com.example.codepairing.remote.Repository

import com.example.codepairing.remote.ApiService
import com.example.codepairing.remote.ApiServiceImpl
import com.example.codepairing.remote.TempDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher

import javax.inject.Inject

class TempRepository @Inject constructor(private val apiServiceImpl: ApiServiceImpl) {

    fun getTemp(): Flow<TempDataModel> = flow {
        emit(apiServiceImpl.getTemp())
    }.flowOn(Dispatchers.IO)
}