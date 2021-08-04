package com.sharad.skycore.data.model

import com.sharad.skycore.data.model.Businesses
import com.sharad.skycore.data.model.Region

/**
 * Created by Sharad-Ubuntu on 07/05/2021.
 */
data class SearchApiResponse(
    val total: String,
    val region: Region,
    val businesses: ArrayList<Businesses>
)