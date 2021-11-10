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

class BoardActivity : AppCompatActivity(), View.OnClickListener {

    val postList = ArrayList<Post>()

    private lateinit var boardAdapter: BoardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.board_list)

        var container = findViewById<ViewPager>(R.id.container)
        var tabs = findViewById<TabLayout>(R.id.tabs)
        var flbtn = findViewById<FloatingActionButton>(R.id.fabNewPost)
        var boardRecyclerView: RecyclerView = findViewById(R.id.messagesList)

        tabs.addTab(tabs.newTab().setText("게시글"))
        tabs.addTab(tabs.newTab().setText("전체 추천글"))
        tabs.addTab(tabs.newTab().setText("나의 추천글"))


        flbtn.setOnClickListener{
            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)
        }

        for (i in 1..10) {
            var mypost = Post("21342", "author", "title", "content", "20211110")
            this.postList.add(mypost)
        }


        boardRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        boardRecyclerView.setHasFixedSize(true)

        boardRecyclerView.adapter = boardAdapter


    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }



    }
