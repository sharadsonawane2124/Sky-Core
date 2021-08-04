package com.sharad.skycore.utils

import com.google.gson.GsonBuilder
import okhttp3.MediaType
import okhttp3.RequestBody
/**
 * Created by Sharad-Ubuntu on 07/05/2021.
 */
object Utility {
    /*
    * Header Keys
    * */
    private const val KEY_HEADER_AUTHORIZATION = "Authorization"


    internal fun getHeaderMap(): HashMap<String, String?> {
        val headerMap = HashMap<String, String?>()

        headerMap[KEY_HEADER_AUTHORIZATION] =
            "Bearer XPFgzKwZGK1yqRxHi0d5xsARFOLpXIvccQj5jekqTnysweGyoIfVUHcH2tPfGq5Oc9kwKHPkcOjk2d1Xobn7aTjOFeop8x41IUfVvg2Y27KiINjYPADcE7Qza0RkX3Yx"

        return headerMap
    }

    internal fun getEncryptedBody(bodyMap: Map<String, Any>): RequestBody {
        val builder = GsonBuilder()
        val gson = builder.create()
        val mapJson: String = gson.toJson(bodyMap)
        return RequestBody.create(MediaType.parse("text/plain"), mapJson)
    }

}