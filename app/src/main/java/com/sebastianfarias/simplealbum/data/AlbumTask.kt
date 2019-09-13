package com.sebastianfarias.simplealbum.data

import com.sebastianfarias.simplealbum.utils.RetrofitClient
import com.sebastianfarias.simplealbum.model.Album
import com.sebastianfarias.simplealbum.service.AlbumService
import retrofit2.Callback

class AlbumTask {

    fun getAlbums(callback : Callback<List<Album>>){
        val photoService =
            RetrofitClient.getRetrofitClient(AlbumService::class.java)
        val serverCall = photoService.getAlbums()
        serverCall.enqueue(callback)
    }
}