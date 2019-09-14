package com.sebastianfarias.simplealbum.view.photodetail

import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.sebastianfarias.simplealbum.R
import com.sebastianfarias.simplealbum.utils.BaseActivity
import kotlinx.android.synthetic.main.photo_detail.*

class PhotoDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_detail)

        sendAnalyticsData(this.localClassName)

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
