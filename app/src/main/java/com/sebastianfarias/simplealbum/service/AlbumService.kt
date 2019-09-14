package com.sebastianfarias.simplealbum.service

import com.sebastianfarias.simplealbum.model.Album
import retrofit2.http.GET

interface AlbumService {

    @GET("albums")
    suspend fun getAlbums(): List<Album>
}