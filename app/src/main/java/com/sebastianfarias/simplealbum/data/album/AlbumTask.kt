package com.sebastianfarias.simplealbum.data.album

import com.sebastianfarias.simplealbum.utils.RetrofitClient
import com.sebastianfarias.simplealbum.service.AlbumService

class AlbumTask {

    var albumService = RetrofitClient.getRetrofitClient(AlbumService::class.java)

    suspend fun getAlbums() = albumService.getAlbums()
}