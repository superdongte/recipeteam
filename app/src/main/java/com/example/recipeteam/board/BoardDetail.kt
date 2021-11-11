package com.example.recipeteam.board

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.recipeteam.R

class BoardDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_detail)

        var boardAuthor = findViewById<TextView>(R.id.board_author)
        var author = intent.getStringExtra("author")
        boardAuthor.text = author

        var boardTitle = findViewById<TextView>(R.id.board_title)
        var title = intent.getStringExtra("title")
        boardTitle.text = title

        var boardContent = findViewById<TextView>(R.id.board_content)
        var content = intent.getStringExtra("content")
        boardContent.text = content
    }
}