package com.example.recipeteam.board

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.recipeteam.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

class BoardActivity : AppCompatActivity(), View.OnClickListener {

    var postList = ArrayList<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_main)

        var tabs = findViewById<TabLayout>(R.id.tabs)
        var flbtn = findViewById<FloatingActionButton>(R.id.fabNewPost)
        var boardRecyclerView: RecyclerView = findViewById(R.id.recyclerBoardList)
        var savedId = intent.getStringExtra("savedId")

        tabs.addTab(tabs.newTab().setText("게시글"))
        tabs.addTab(tabs.newTab().setText("내가 쓴 글"))


        flbtn.setOnClickListener{
            val intent = Intent(this, PostActivity::class.java)
            intent.putExtra("savedId", savedId)
            startActivity(intent)
        }

        /*var postList = arrayListOf(
            PostView(R.drawable.ic_baseline_account_circle_24, "author", "title", "content"),
            PostView(R.drawable.ic_baseline_account_circle_24, "author", "title", "content"),
            PostView(R.drawable.ic_baseline_account_circle_24, "author", "title", "content"),
            PostView(R.drawable.ic_baseline_account_circle_24, "author", "title", "content")
        )*/

        postList = arrayListOf(
            Post("uid", "author", "title", "content", "20211111")
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
//            .addConverterFactory(GsonConverterFactory.create(gson1))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

       // val service: retrofit.create(PostService::class.java)
       val service = retrofit.create(PostService::class.java)
        service.getPostList().enqueue(object: Callback<PostList>{
            override fun onResponse(call: Call<PostList>, response: Response<PostList>) {
                var postList1 = response.body()
                for(i in 0..postList1!!.datas.size-1) {
                    postList = arrayListOf(
                        Post(postList1!!.datas.get(i).uid, postList1!!.datas.get(i).author, postList1!!.datas.get(i).title,
                            postList1!!.datas.get(i).content, postList1!!.datas.get(i).regdate)
                    )
                }
            }

            override fun onFailure(call: Call<PostList>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
*/



    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }



    }
