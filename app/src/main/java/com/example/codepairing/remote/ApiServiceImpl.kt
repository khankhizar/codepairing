package com.example.codepairing.remote

import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService) {
     suspend fun getTemp(): TempDataModel = apiService.getTemp()
}