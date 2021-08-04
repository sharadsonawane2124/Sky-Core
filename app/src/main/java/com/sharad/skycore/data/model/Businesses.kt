package com.sharad.skycore.data.model

/**
 * Created by Sharad-Ubuntu on 07/05/2021.
 */
data class Businesses(
    val distance: String,
    val image_url: String,
    val rating: String,
    val coordinates: Coordinates,
    val review_count: String,
    val transactions: ArrayList<String>,
    val url: String,
    val display_phone: String,
    val phone: String,
    val price: String,
    val name: String,
    val alias: String,
    val location: Location,
    val id: String,
    val categories: ArrayList<Categories>,
    val is_closed: Boolean
)
