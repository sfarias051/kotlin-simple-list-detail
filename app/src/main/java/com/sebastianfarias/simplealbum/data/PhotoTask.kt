package com.sebastianfarias.simplealbum.data

import com.sebastianfarias.simplealbum.utils.RetrofitClient
import com.sebastianfarias.simplealbum.model.Photo
import com.sebastianfarias.simplealbum.service.PhotoService
import retrofit2.Callback

class PhotoTask {

    fun getPhoto(callback : Callback<List<Photo>>, id : String){
        val photoService =
            RetrofitClient.getRetrofitClient(PhotoService::class.java)
        val serverCall = photoService.getPhotos(id)
        serverCall.enqueue(callback)
    }
}