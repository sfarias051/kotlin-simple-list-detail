package com.sebastianfarias.simplealbum.view.photodetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.sebastianfarias.simplealbum.R
import com.sebastianfarias.simplealbum.data.AlbumTask
import com.sebastianfarias.simplealbum.model.Album
import kotlinx.android.synthetic.main.photo_detail.*
import kotlinx.android.synthetic.main.photo_list_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_detail)

        var intent = getIntent()
        if (getIntent().hasExtra(Intent.EXTRA_TITLE)){
            tv_photo_detail_title.text = intent.getStringExtra(Intent.EXTRA_TITLE)
            Glide.with(this)
                .load(intent.getStringExtra(Intent.EXTRA_TEXT))
                .fitCenter()
                .placeholder(R.drawable.baseline_photo_black_48)
                .error(R.drawable.baseline_broken_image_black_48)
                .fallback(R.drawable.baseline_broken_image_black_48)
                .into(iv_photo_detail_image)
        }
    }
}
