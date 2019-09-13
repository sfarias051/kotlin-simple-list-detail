package com.sebastianfarias.simplealbum.service

import com.sebastianfarias.simplealbum.model.Album
import retrofit2.Call
import retrofit2.http.GET

interface AlbumService {

    @GET("albums")
    fun getAlbums(): Call<List<Album>>
}