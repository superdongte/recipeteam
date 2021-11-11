package com.example.recipeteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RecipeDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_detail)

        var recipeName = findViewById<TextView>(R.id.text_name)
        val cname = intent.getStringExtra("cname")
        recipeName.text = cname

    }
}