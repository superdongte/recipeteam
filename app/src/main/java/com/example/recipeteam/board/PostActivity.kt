package com.example.recipeteam.board

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.recipeteam.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate
import java.time.LocalDate.now

class PostActivity : AppCompatActivity() {

    lateinit var title1 : EditText
    lateinit var content1 : EditText
    lateinit var uid1 : String
    lateinit var author1 : String
    @RequiresApi(Build.VERSION_CODES.O)
    var regdate1 : LocalDate = LocalDate.now()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)

        title1 = findViewById<EditText>(R.id.fieldTitle)
        content1 = findViewById<EditText>(R.id.fieldContent)
        uid1 = intent.getStringExtra("savedId").toString()
        author1 = intent.getStringExtra("Email").toString()

        var fbtn = findViewById<FloatingActionButton>(R.id.fabSubmitPost)

        fbtn.setOnClickListener{
            //postinsert()
            val intent = Intent(this, BoardActivity::class.java)
            startActivity(intent)
        }
    }

    /*private fun postinsert() {
        val baseURL = ""
        var gson1 : Gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit
            .Builder()
            .baseUrl(baseURL)
//            .addConverterFactory(GsonConverterFactory.create(gson1))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var service = retrofit.create(PostService::class.java)

        service.insertPost(Post(uid =uid1, author =author1, title =title1.toString(), content =content1.toString(), regdate = regdate1.toString()))
            .enqueue(object : Callback<Post> {
                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    var postList1 = response.body()
                }

                override fun onFailure(call: Call<Post>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }*/
}