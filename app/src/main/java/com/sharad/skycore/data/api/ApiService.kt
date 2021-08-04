package com.sharad.skycore.data.api

import com.sharad.skycore.data.model.SearchApiResponse
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Url
/**
 * Created by Sharad-Ubuntu on 07/05/2021.
 */
interface ApiService {

    @GET
    suspend fun getRestaurants(
        @Url url: String,
        @HeaderMap headers: Map<String, String?>
    ): SearchApiResponse
}