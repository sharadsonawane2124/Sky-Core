package com.sharad.skycore.data.model
/**
 * Created by Sharad-Ubuntu on 07/05/2021.
 */
data class Location(
    val country: String,
    val address3: String,
    val address2: String,
    val city: String,
    val address1: String,
    val display_address: ArrayList<String>,
    val state: String,
    val zip_code: String
)