package com.sebastianfarias.simplealbum.view.photo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.sebastianfarias.simplealbum.R
import com.sebastianfarias.simplealbum.model.Photo
import kotlinx.android.synthetic.main.photo_list_item.view.*

class PhotoViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.photo_list_item, parent, false)) {

    private lateinit var photo: Photo

    fun bind(photo: Photo, clickListener: (Photo) -> Unit) {
        this.photo = photo
        itemView.tv_photo_title.text = photo.title
        Glide.with(itemView)
            .load(photo.thumbnailUrl)
            .centerCrop()
            .placeholder(R.drawable.baseline_photo_black_48)
            .error(R.drawable.baseline_broken_image_black_48)
            .fallback(R.drawable.baseline_broken_image_black_48)
            .transform(CircleCrop())
            .into(itemView.iv_photo_list_image)
        itemView.setOnClickListener {clickListener(photo)}
    }
}