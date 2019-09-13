package com.sebastianfarias.simplealbum.view.photo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sebastianfarias.simplealbum.model.Photo

class PhotoAdapter (val clickListener: (Photo) -> Unit) : RecyclerView.Adapter<PhotoViewHolder>() {
    var photoList : List<Photo> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PhotoViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photoList[position], clickListener)
    }

    fun setPhotoListItems(photoList: List<Photo>){
        this.photoList = photoList
        notifyDataSetChanged()
    }

}
