package com.example.recipeteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class loginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        var InputId=findViewById<EditText>(R.id.EdtID)
        var InputPassword=findViewById<EditText>(R.id.EdtPassword)
        var btnJoin=findViewById<Button>(R.id.btnJoin)

       btnJoin.setOnClickListener{
           val intent=Intent(this,JoinActivity::class.java)
           startActivity(intent)
       }



}
}