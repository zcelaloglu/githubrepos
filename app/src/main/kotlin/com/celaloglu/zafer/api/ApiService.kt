package com.celaloglu.zafer.api

import com.celaloglu.zafer.models.response.ReposResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users/{user}/repos")
    suspend fun getRepos(@Path("user") user: String): List<ReposResponse>
}