package com.sharad.skycore.data.repository

import com.sharad.skycore.data.api.ApiHelper


class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getRestaurants(url: Int)=apiHelper.getRestaurants(url)


}