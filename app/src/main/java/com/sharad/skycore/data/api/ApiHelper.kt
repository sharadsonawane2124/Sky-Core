package com.sharad.skycore.data.api

import com.sharad.skycore.data.model.SearchApiResponse
import com.sharad.skycore.utils.Utility

/**
 * Created by Sharad-Ubuntu on 07/05/2021.
 */
class ApiHelper(private val apiService: ApiService) {


    suspend fun getRestaurants(radius: Int): SearchApiResponse {
//        val queryMap = HashMap<String, String>()
//        queryMap["radius"] = radius
//        queryMap["location"] = "NYC"
        val requestUrl = "https://api.yelp.com/v3/businesses/search?location=NYC&radius=$radius"
        return apiService.getRestaurants(requestUrl, Utility.getHeaderMap())
    }
}