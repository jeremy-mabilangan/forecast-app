package com.jeremymabilangan.forecast.data.network

import okhttp3.Interceptor
import okhttp3.Response

class AccessKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val httpURL = chain.request()
            .url()
            .newBuilder()
            .addQueryParameter("access_key", API_KEY)
            .build()

        val request = chain.request()
            .newBuilder()
            .url(httpURL)
            .build()

        return chain.proceed(request)
    }
}