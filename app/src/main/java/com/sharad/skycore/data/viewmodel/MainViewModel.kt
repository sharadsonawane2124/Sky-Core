package com.sharad.skycore.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sharad.skycore.data.api.Resource
import com.sharad.skycore.data.repository.MainRepository
import kotlinx.coroutines.Dispatchers

/**
 * Created by Sharad-Ubuntu on 07/05/2021.
 */
class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getRestaurants(s: Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getRestaurants(s)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}