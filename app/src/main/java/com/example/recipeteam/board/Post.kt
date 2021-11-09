package com.example.recipeteam.board

import java.util.*

data class Post (
    val uid: String,
    val author: String,
    val title: String,
    val content: String,
    val regdate: Date
        )