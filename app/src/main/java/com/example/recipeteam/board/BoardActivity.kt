package com.example.recipeteam.board

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.recipeteam.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

class BoardActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var boardAdapter: BoardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.board_list)

        var container = findViewById<ViewPager>(R.id.container)
        var tabs = findViewById<TabLayout>(R.id.tabs)
        var flbtn = findViewById<FloatingActionButton>(R.id.fabNewPost)
        var BoardRecyclerView = findViewById<RecyclerView>(R.id.messagesList)

        tabs.addTab(tabs.newTab().setText("게시글"))
        tabs.addTab(tabs.newTab().setText("전체 추천글"))
        tabs.addTab(tabs.newTab().setText("나의 추천글"))


        flbtn.setOnClickListener{
            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)
        }



    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }



    }
