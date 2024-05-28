package com.example.codepairing.remote.di

import com.example.codepairing.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceFactory {
    private const val OK_HTTP_TIMEOUT = 60L


    @Provides
    @Singleton
    fun create(baseUrl: String): ApiService {
        val retrofit = createRetrofit(baseUrl)
        return retrofit.create(ApiService::class.java)
    }

    private fun createRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .client(createOkHttpClient(createLoggingInterceptor()))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private fun createOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(loggingInterceptor)
            .connectTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
            .build()

    }

    private fun createLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            HttpLoggingInterceptor.Level.NONE
        }
    }

}