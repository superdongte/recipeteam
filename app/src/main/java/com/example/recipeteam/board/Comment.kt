package com.example.recipeteam.board

import java.util.*

data class Comment (
    val uid : String,
    val author: String,
    val text: String,
    val regdate: Date
        )