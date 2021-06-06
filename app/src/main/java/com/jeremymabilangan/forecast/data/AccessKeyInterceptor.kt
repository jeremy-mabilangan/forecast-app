package com.jeremymabilangan.forecast.data

import okhttp3.Interceptor
import okhttp3.Response


/**
 * Created by Ralph Gabrielle Orden on 6/6/21.
 */

class AccessKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())


        //            val requestInterceptor = Interceptor { chain ->
//
//                val url = chain.request()
//                    .url()
//                    .newBuilder()
//                    .addQueryParameter("access_key", API_KEY)
//                    .build()
//                val request = chain.request()
//                    .newBuilder()
//                    .url(url)
//                    .build()
//
//                return@Interceptor chain.proceed(request)
//            }

        val htttpURL = chain.request()
            .url()
            .newBuilder()
            .addQueryParameter("access_key", API_KEY)
            .build()

        val request = chain.request()
            .newBuilder()
            .url(htttpURL)
            .build()

        return chain.proceed(request)
    }
}