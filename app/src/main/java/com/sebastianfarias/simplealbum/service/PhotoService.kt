package com.sebastianfarias.simplealbum.service

import com.sebastianfarias.simplealbum.model.Photo
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoService {

    @GET("photos")
    suspend fun getPhotos(@Query("albumId") id: String): List<Photo>
}