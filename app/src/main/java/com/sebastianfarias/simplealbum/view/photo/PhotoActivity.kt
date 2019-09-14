package com.sebastianfarias.simplealbum.view.photo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sebastianfarias.simplealbum.R
import com.sebastianfarias.simplealbum.data.photo.PhotoViewModel
import com.sebastianfarias.simplealbum.data.photo.PhotoViewModelFactory
import com.sebastianfarias.simplealbum.model.Photo
import com.sebastianfarias.simplealbum.view.photodetail.PhotoDetailActivity
import kotlinx.android.synthetic.main.photo_list.*

class PhotoActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: PhotoAdapter
    lateinit var photoViewModel: PhotoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_list)

        recyclerView = findViewById(R.id.recyclerview_photo_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = PhotoAdapter({photo : Photo -> photoItemClicked(photo)})
        recyclerView.adapter = recyclerAdapter

        var intent = getIntent()
        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            var idAlbum = intent.getStringExtra(Intent.EXTRA_TEXT)
            var titleAlbum = intent.getStringExtra(Intent.EXTRA_TITLE)
            tv_photo_list_title.text = titleAlbum
            photoViewModel = ViewModelProviders.of(this, PhotoViewModelFactory(idAlbum)).get(PhotoViewModel::class.java)
            getPhotoList()
        }

    }

    private fun getPhotoList() {
        photoViewModel.getPhotoList.observe(this, Observer {
            recyclerAdapter.setPhotoListItems(it)
        })
    }

    private fun photoItemClicked(photo : Photo){
        val detailActivityIntent = Intent(this, PhotoDetailActivity::class.java)
        detailActivityIntent.putExtra(Intent.EXTRA_TITLE, photo.title)
        detailActivityIntent.putExtra(Intent.EXTRA_TEXT, photo.url)
        startActivity(detailActivityIntent)
    }
}