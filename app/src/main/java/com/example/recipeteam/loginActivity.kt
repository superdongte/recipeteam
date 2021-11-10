package com.example.recipeteam

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class loginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        var InputId=findViewById<EditText>(R.id.EdtID)
        var InputPassword=findViewById<EditText>(R.id.EdtPassword)
        var btnJoin=findViewById<Button>(R.id.btnJoin)
        var btnLogin=findViewById<Button>(R.id.btnLogin)
        var dlg= AlertDialog.Builder(this@loginActivity)
        var IdCheck=false
        var PassCheck=false



        //// 쉐어드로부터 저장된 id, pw 가져오기
        btnLogin.setOnClickListener {
            val sharedPreference = getSharedPreferences("file name", Context.MODE_PRIVATE)
            var savedId=sharedPreference.getString("id","")
            var savedPassword=sharedPreference.getString("pw","")


            var pass1:String=InputId.text.toString()
            var pass2:String=InputPassword.text.toString()



           if(pass1 == savedId && pass2 == savedPassword){
                // 로그인 성공 다이얼로그 보여주기
               val intent=Intent(this,MainActivity::class.java)
               startActivity(intent)


            }
            else{
                // 로그인 실패 다이얼로그 보여주기
                dlg.setTitle("Error")
                dlg.setMessage("아이디 혹은 비밀번호 틀렸습니다")
                dlg.setIcon(R.mipmap.ic_launcher)
               dlg.show()
            }
        }
        

            btnJoin.setOnClickListener{
           val intent=Intent(this,JoinActivity::class.java)
           startActivity(intent)
       }



}
}