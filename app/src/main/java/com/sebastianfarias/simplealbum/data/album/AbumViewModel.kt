package com.sebastianfarias.simplealbum.data.album

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers

class AlbumViewModel : ViewModel(){

    val repository: AlbumTask = AlbumTask()

    val getAlbumList = liveData(Dispatchers.IO){
        val responseAlbum = repository.getAlbums()
        emit(responseAlbum)
    }

}