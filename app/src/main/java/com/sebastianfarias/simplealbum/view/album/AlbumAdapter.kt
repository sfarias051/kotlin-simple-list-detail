package com.sebastianfarias.simplealbum.view.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sebastianfarias.simplealbum.model.Album

class AlbumAdapter (val clickListener: (Album) -> Unit) : RecyclerView.Adapter<AlbumViewHolder>() {
    var albumList : List<Album> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AlbumViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(albumList[position], clickListener)
    }

    fun setAlbumListItems(albumList: List<Album>){
        this.albumList = albumList
        notifyDataSetChanged()
    }

}
