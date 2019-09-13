package com.sebastianfarias.simplealbum.view.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sebastianfarias.simplealbum.R
import com.sebastianfarias.simplealbum.model.Album
import kotlinx.android.synthetic.main.album_list_item.view.*

class AlbumViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.album_list_item, parent, false)) {

    private lateinit var album: Album

    fun bind(album: Album, clickListener: (Album) -> Unit) {
        this.album = album
        itemView.tv_album_title.text = album.title
        itemView.setOnClickListener {clickListener(album)}
    }
}