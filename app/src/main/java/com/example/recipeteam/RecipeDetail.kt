package com.example.recipeteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.contentValuesOf
import com.example.recipeteam.recipe.Cook

class RecipeDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_detail)

        var recipeName = findViewById<TextView>(R.id.text_name)
        val cname = intent.getStringExtra("cname")
        recipeName.text = cname

        var recipeContent = findViewById<TextView>(R.id.post_content)
        val ccontent = intent.getStringExtra("ccontent")
        recipeContent.text = ccontent

        /*var recipeBody = findViewById<TextView>(R.id.post_content)
        val cookList = intent.getSerializableExtra("cookList") as ArrayList<Cook>
        recipeBody.text = cookList[3].toString()*/

    }
}