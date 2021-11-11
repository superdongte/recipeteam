package com.example.recipeteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.recipeteam.recipe.RecipeDetail

class CookrecipeList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cookrecipe_list)

        var Imgsea=findViewById<ImageView>(R.id.sea1)


        Imgsea.setOnClickListener {
            val intent= Intent(this, RecipeDetail::class.java)
            startActivity(intent)
        }
    }
}