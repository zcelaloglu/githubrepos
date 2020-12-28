package com.celaloglu.zafer.commons

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        var modifiedRequest = request
        modifiedRequest = request.newBuilder()
            .header("Authorization", "token " + refreshToken())
            .build()
        val response = chain.proceed(modifiedRequest)
        val unauthorized = response.code == 401 || response.code == 500
        if (unauthorized) {
            modifiedRequest = request.newBuilder()
                .header("Authorization", "token " + refreshToken())
                .build()
            return chain.proceed(modifiedRequest)
        }
        return response
    }

    private fun refreshToken(): String {
        return "f3d868c5e7097e8963f5966b69a267fbb851baee"
    }
}