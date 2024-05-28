package com.example.codepairing.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/2.5/weather?lat=0&lon=0&appid=912c25fe5a896d110435f8823adacf1a&units=metric")
    suspend fun getTemp(
    ): TempDataModel
}