package com.celaloglu.zafer.di.modules

import com.celaloglu.zafer.api.ApiService
import com.celaloglu.zafer.commons.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single { provideService(get()) }

    single {
        provideRetrofit(
            get(),
            provideBaseUrl()
        )
    }

    single { provideOkHttpClient() }

}

fun provideOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(TokenInterceptor())
        .addInterceptor(httpLoggingInterceptor).build()
}

fun provideRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
    .build()
}

fun provideService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

fun provideBaseUrl(): String = "https://api.github.com"