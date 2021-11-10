package com.example.recipeteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar

class BoardList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        var boardRegister=findViewById<View>(R.id.fabNewPost)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.board_list)

//        boardRegister.setOnClickListener { view ->
//            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                .setAction("Action", null)
//                .show()
//        }



    }
}
