package com.example.recipeteam.recipe

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.recipeteam.R

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

        var recipeRecipe = findViewById<TextView>(R.id.ingredients)
        val crecipe = intent.getStringExtra("crecipe")
        recipeRecipe.text = crecipe

        var recipeTime = findViewById<TextView>(R.id.time)
        val ctime = intent.getStringExtra("ctime")
        recipeTime.text = ctime

        var recipeImage = findViewById<ImageView>(R.id.imageView)
        var cimage = intent.getParcelableExtra<Bitmap>("bitmap")
        recipeImage.setImageBitmap(cimage)

        /*var recipeBody = findViewById<TextView>(R.id.post_content)
        val cookList = intent.getSerializableExtra("cookList") as ArrayList<Cook>
        recipeBody.text = cookList[3].toString()*/

    }
}