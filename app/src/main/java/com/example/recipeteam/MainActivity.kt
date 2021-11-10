package com.example.recipeteam




import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       var btnCook=findViewById<Button>(R.id.btnCook)
        var btnBoard=findViewById<Button>(R.id.btnBoard)



        btnCook.setOnClickListener {
            val intent=Intent(this,CookrecipeList::class.java)
            startActivity(intent)

            }



        btnBoard.setOnClickListener {
            val intent=Intent(this,BoardList::class.java)
            startActivity(intent)

        }







            }






        }







