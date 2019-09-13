package com.sebastianfarias.simplealbum.view.photo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sebastianfarias.simplealbum.R
import com.sebastianfarias.simplealbum.data.PhotoTask
import com.sebastianfarias.simplealbum.model.Photo
import com.sebastianfarias.simplealbum.view.photodetail.PhotoDetailActivity
import kotlinx.android.synthetic.main.photo_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: PhotoAdapter

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
            getPhotoList(idAlbum)
        }

    }

    private fun getPhotoList(id: String) {
        var response = PhotoTask()
        val callback = object : Callback<List<Photo>> {
            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                try {
                    recyclerAdapter.setPhotoListItems(emptyList())
                } catch(e: Exception){
                    Log.d("TASK", e.toString())
                }
            }

            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                recyclerAdapter.setPhotoListItems(response.body()!!)
            }
        }
        response.getPhoto(callback, id)

    }

    private fun photoItemClicked(photo : Photo){
        Toast.makeText(this, "CLICKED : " + photo.title, Toast.LENGTH_LONG).show()

        val detailActivityIntent = Intent(this, PhotoDetailActivity::class.java)
        detailActivityIntent.putExtra(Intent.EXTRA_TITLE, photo.title)
        detailActivityIntent.putExtra(Intent.EXTRA_TEXT, photo.url)
        startActivity(detailActivityIntent)
    }
}