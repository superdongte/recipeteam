package com.example.recipeteam.recipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
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

class RecipeRegister : AppCompatActivity(),View.OnClickListener {

    lateinit var recipeName: EditText
    lateinit var recipeRecipe: EditText
    lateinit var recipeContent: EditText
    lateinit var recipeImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_post)

       // var btn = findViewById<Button>(R.id.btn)

        recipeName = findViewById(R.id.editTitle)
        recipeRecipe = findViewById(R.id.editIngredents)
        recipeContent = findViewById(R.id.editContent)
        recipeImage = findViewById(R.id.imageView2)



        var facpbtn=findViewById<FloatingActionButton>(R.id.fabNewCookPost)

       facpbtn.setOnClickListener {
           recipeinsert()
           val intent= Intent(this, CookListAcitivity::class.java)
           startActivity(intent)
       }




    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    private fun recipeinsert() {
        var rimage = recipeImage.setImageResource(R.drawable.ic_action_account_circle_40)
        var rname = recipeName.text.toString()
        var rcontent = recipeContent.text.toString()
        var rrecipe = recipeRecipe.text.toString()


        val baseURL = "http://10.100.204.69:8077"
        var gson1 : Gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit
            .Builder()
            .baseUrl(baseURL)
//            .addConverterFactory(GsonConverterFactory.create(gson1))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var service = retrofit.create(CookService::class.java)

        service.insertCookInfo(Cook(cimage = "null", cname = rname,
            cookcontent = rcontent, crecipe = rrecipe))
       /* service.insertCookInfo(Cook(cookid = 3, cname = "cname5", cimage = "null",
            crecipe = "recipe5", cookcontent = "content5"))*/
        //service.insertCookInfo(Cook(cimage = "null", cname="cname5", cookcontent="content5", crecipe="crecipe5"))
            .enqueue(object : Callback<Cook> {
                override fun onResponse(call: Call<Cook>, response: Response<Cook>) {
                    Toast.makeText(applicationContext, "android insert response", Toast.LENGTH_SHORT).show()
                    var cookList1 = response.body()
                }

                override fun onFailure(call: Call<Cook>, t: Throwable) {
                    return Toast.makeText(applicationContext, "android insert fail", Toast.LENGTH_SHORT).show()

                }

            })


    }


}