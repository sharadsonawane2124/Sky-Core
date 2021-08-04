package com.sharad.skycore.data.api

import com.sharad.skycore.utils.Status
import com.sharad.skycore.utils.Status.ERROR
import com.sharad.skycore.utils.Status.LOADING
import com.sharad.skycore.utils.Status.SUCCESS

/**
 * Created by Sharad-Ubuntu on 07/05/2021.
 */
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(status = SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): Resource<T> =
            Resource(status = ERROR, data = data, message = message)

        fun <T> loading(data: T?): Resource<T> = Resource(status = LOADING, data = data, message = null)
    }
}