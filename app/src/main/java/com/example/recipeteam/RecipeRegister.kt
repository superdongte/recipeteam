package com.example.recipeteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class RecipeRegister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_register)



        var fab=findViewById<View>(R.id.fabNewPost)

//       fab.setOnClickListener {view->
//            Toast.makeText(applicationContext,"등록이 완료되었습니다",Toast.LENGTH_SHORT)
//           val intent= Intent(this,CookrecipeList::class.java)
//           startActivity(intent)
//       }


    }
}