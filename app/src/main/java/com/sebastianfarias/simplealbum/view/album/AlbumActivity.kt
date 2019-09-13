package com.sebastianfarias.simplealbum.view.album

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sebastianfarias.simplealbum.data.AlbumTask
import com.sebastianfarias.simplealbum.R
import com.sebastianfarias.simplealbum.model.Album
import com.sebastianfarias.simplealbum.view.photo.PhotoActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.album_list)

        recyclerView = findViewById(R.id.recyclerview_album_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = AlbumAdapter({album : Album -> albumItemClicked(album)})
        recyclerView.adapter = recyclerAdapter

        getAlbumList()
    }

    private fun getAlbumList() {
        var response = AlbumTask()
        val callback = object : Callback<List<Album>> {
            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                try {
                    recyclerAdapter.setAlbumListItems(emptyList())
                } catch(e: Exception){
                    Log.d("TASK", e.toString())
                }
            }

            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                recyclerAdapter.setAlbumListItems(response.body()!!)
            }
        }
        response.getAlbums(callback)

    }

    private fun albumItemClicked(album : Album){
        Toast.makeText(this, "CLICKED : " + album.title, Toast.LENGTH_LONG).show()

        val photoActivityIntent = Intent(this, PhotoActivity::class.java)
        photoActivityIntent.putExtra(Intent.EXTRA_TEXT, album.id.toString())
        photoActivityIntent.putExtra(Intent.EXTRA_TITLE, album.title)
        startActivity(photoActivityIntent)
    }
}