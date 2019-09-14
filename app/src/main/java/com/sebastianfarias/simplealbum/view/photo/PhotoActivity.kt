package com.sebastianfarias.simplealbum.view.photo

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sebastianfarias.simplealbum.R
import com.sebastianfarias.simplealbum.data.photo.PhotoViewModel
import com.sebastianfarias.simplealbum.data.photo.PhotoViewModelFactory
import com.sebastianfarias.simplealbum.model.Photo
import com.sebastianfarias.simplealbum.utils.BaseActivity
import com.sebastianfarias.simplealbum.view.photodetail.PhotoDetailActivity
import kotlinx.android.synthetic.main.photo_list.*
import kotlinx.android.synthetic.main.photo_list.swipe_refresh_list

class PhotoActivity : BaseActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: PhotoAdapter
    lateinit var photoViewModel: PhotoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_list)

        sendAnalyticsData(this.localClassName)

        recyclerView = findViewById(R.id.recyclerview_photo_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = PhotoAdapter({photo : Photo -> photoItemClicked(photo)})
        recyclerView.adapter = recyclerAdapter

        swipe_refresh_list.setColorSchemeResources(
            android.R.color.holo_blue_bright,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light)
        swipe_refresh_list.setOnRefreshListener {
            if(hasInternetConnection()) getPhotoList()
        }

        var intent = getIntent()
        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            var idAlbum = intent.getStringExtra(Intent.EXTRA_TEXT)
            var titleAlbum = intent.getStringExtra(Intent.EXTRA_TITLE)
            tv_photo_list_title.text = titleAlbum
            photoViewModel = ViewModelProviders.of(this, PhotoViewModelFactory(idAlbum)).get(PhotoViewModel::class.java)
            if(hasInternetConnection()) getPhotoList()
        }

    }

    private fun getPhotoList() {
        swipe_refresh_list.isRefreshing = true
        photoViewModel.getPhotoList.observe(this, Observer {
            recyclerAdapter.setPhotoListItems(it)
            swipe_refresh_list.isRefreshing = false
        })
    }

    private fun photoItemClicked(photo : Photo){
        val detailActivityIntent = Intent(this, PhotoDetailActivity::class.java)
        detailActivityIntent.putExtra(Intent.EXTRA_TITLE, photo.title)
        detailActivityIntent.putExtra(Intent.EXTRA_TEXT, photo.url)
        startActivity(detailActivityIntent)
    }
}