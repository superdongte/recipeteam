package com.example.recipeteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.recipeteam.board.BoardActivity
import com.example.recipeteam.recipe.CookListAcitivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnReceipe=findViewById<Button>(R.id.btnCook)
        var btnBoard=findViewById<Button>(R.id.btnBoard)
        var savedId= intent.getStringExtra("savedId")

        btnReceipe.setOnClickListener {
            val intent= Intent(this, CookListAcitivity::class.java)
            startActivity(intent)
        }


        btnBoard.setOnClickListener {
            val intent= Intent(this,BoardActivity::class.java)
            intent.putExtra("savedId", savedId)
            startActivity(intent)
        }
    }
}