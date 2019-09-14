package com.sebastianfarias.simplealbum.data.photo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PhotoViewModelFactory(val id: String) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PhotoViewModel(id) as T
    }
}