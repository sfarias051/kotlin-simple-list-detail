package com.sebastianfarias.simplealbum.data.photo

import com.sebastianfarias.simplealbum.utils.RetrofitClient
import com.sebastianfarias.simplealbum.service.PhotoService

class PhotoTask {

    var photoService = RetrofitClient.getRetrofitClient(PhotoService::class.java)

    suspend fun getPhotos(id: String) = photoService.getPhotos(id)
}