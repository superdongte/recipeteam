package com.example.recipeteam.board

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.recipeteam.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)

        var title = findViewById<EditText>(R.id.fieldTitle)
        var content = findViewById<EditText>(R.id.fieldContent)
        var fbtn = findViewById<FloatingActionButton>(R.id.fabSubmitPost)

        fbtn.setOnClickListener{
            val intent = Intent(this, BoardActivity::class.java)
            startActivity(intent)
        }
    }
}