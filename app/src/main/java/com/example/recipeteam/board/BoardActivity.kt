package com.example.recipeteam.board

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.recipeteam.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BoardActivity : AppCompatActivity(), View.OnClickListener {

    val postList = ArrayList<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_main)

        var container = findViewById<ViewPager>(R.id.container)
        var tabs = findViewById<TabLayout>(R.id.tabs)
        var flbtn = findViewById<FloatingActionButton>(R.id.fabNewPost)
        var boardRecyclerView: RecyclerView = findViewById(R.id.recyclerBoardList)

        tabs.addTab(tabs.newTab().setText("게시글"))
        tabs.addTab(tabs.newTab().setText("내가 쓴 글"))


        flbtn.setOnClickListener{
            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)
        }

        var postList = arrayListOf(
            PostView(R.drawable.ic_baseline_account_circle_24, "author", "title", "content"),
            PostView(R.drawable.ic_baseline_account_circle_24, "author", "title", "content"),
            PostView(R.drawable.ic_baseline_account_circle_24, "author", "title", "content"),
            PostView(R.drawable.ic_baseline_account_circle_24, "author", "title", "content")
        )

        boardRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        boardRecyclerView.setHasFixedSize(true)

        boardRecyclerView.adapter = BoardAdapter(postList)

    }
/*

    private fun request() {
        val baseURL = ""
        var gson1 : Gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit
            .Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: retrofit.create(PostService::class.java)

        service.getPost().enqueue(object: Callback<PostList>{
            override fun onResponse(call: Call<PostList>, response: Response<PostList>) {
                var postList1 = response.body()
            }
        })
    }
*/

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }



    }
