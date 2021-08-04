package com.sharad.skycore.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/**
 * Created by Sharad-Ubuntu on 07/05/2021.
 */
object RetrofitBuilder {

    private const val BASE_URL = "https://api.yelp.com/v3/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}