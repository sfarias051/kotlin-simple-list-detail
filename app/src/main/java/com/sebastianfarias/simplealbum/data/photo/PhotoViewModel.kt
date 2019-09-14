package com.sebastianfarias.simplealbum.data.photo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class PhotoViewModel(val id : String) : ViewModel(){
    val repository : PhotoTask = PhotoTask()

    val getPhotoList = liveData(Dispatchers.IO) {
        val responsePhotos = repository.getPhotos(id)
        emit(responsePhotos)
    }
}