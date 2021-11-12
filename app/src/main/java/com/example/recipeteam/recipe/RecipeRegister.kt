package com.example.recipeteam.recipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.recipeteam.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeRegister : AppCompatActivity() {

    var recipeUid: Int = 0
    lateinit var recipeName: EditText
    lateinit var recipeRecipe: EditText
    lateinit var recipeContent: EditText
    lateinit var recipeImage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_post)




        var fab=findViewById<FloatingActionButton>(R.id.fabNewCookPost)

       fab.setOnClickListener {
            Toast.makeText(applicationContext,"등록이 완료되었습니다",Toast.LENGTH_SHORT)
           val intent= Intent(this,CookListAcitivity::class.java)
           startActivity(intent)
       }



    }
/*
    private fun recipeinsert() {
        val baseURL = "http://192.168.43.66:8077"
        var gson1 : Gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit
            .Builder()
            .baseUrl(baseURL)
//            .addConverterFactory(GsonConverterFactory.create(gson1))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var service = retrofit.create(CookService::class.java)

        service.insertCookInfo(Cook(cookid = recipeUid + 1, cname = recipeName.toString(), cimage = recipeImage.toString(),
        crecipe = recipeRecipe.toString(), cookcontent = recipeContent.toString()))
            .enqueue(object : Callback<Cook> {
                override fun onResponse(call: Call<Cook>, response: Response<Cook>) {
                    var cookList1 = response.body()
                }

                override fun onFailure(call: Call<Cook>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })


    }

    */
}