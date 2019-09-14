package com.sebastianfarias.simplealbum.view.album

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sebastianfarias.simplealbum.R
import com.sebastianfarias.simplealbum.data.album.AlbumViewModel
import com.sebastianfarias.simplealbum.model.Album
import com.sebastianfarias.simplealbum.utils.BaseActivity
import com.sebastianfarias.simplealbum.view.photo.PhotoActivity

class AlbumActivity : BaseActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: AlbumAdapter
    lateinit var albumViewModel: AlbumViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.album_list)

        recyclerView = findViewById(R.id.recyclerview_album_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = AlbumAdapter({album : Album -> albumItemClicked(album)})
        recyclerView.adapter = recyclerAdapter

        albumViewModel = ViewModelProviders.of(this).get(AlbumViewModel::class.java)
        if(hasInternetConnection()) getAlbumList()
    }

    private fun getAlbumList() {
        albumViewModel.getAlbumList.observe(this, Observer {
            recyclerAdapter.setAlbumListItems(it)
        })
    }

    private fun albumItemClicked(album : Album){
        val photoActivityIntent = Intent(this, PhotoActivity::class.java)
        photoActivityIntent.putExtra(Intent.EXTRA_TEXT, album.id.toString())
        photoActivityIntent.putExtra(Intent.EXTRA_TITLE, album.title)
        startActivity(photoActivityIntent)
    }
}