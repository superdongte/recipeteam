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

class JoinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.join)

        var EdtId=findViewById<EditText>(R.id.EditID)
        val Edtemail=findViewById<EditText>(R.id.EdtEmail)
        var Edtpassword=findViewById<EditText>(R.id.EdtPassword)
        var EdtConPassword=findViewById<EditText>(R.id.EdtPasswordCheck)
        var EdtJoin=findViewById<Button>(R.id.btnJoin)
        var behind=findViewById<Button>(R.id.btnBehind)
        var isSamePassword=false //패스워드 확인체크
        var isBlank=false // 비워져 있는지 확인


        EdtJoin.setOnClickListener {
            var pass1:String=Edtpassword.text.toString()
            var pass2:String=EdtConPassword.text.toString()
            var id:String=EdtId.text.toString()
            var Email:String=Edtemail.text.toString()
            var dlg=AlertDialog.Builder(this@JoinActivity)

            if(id.isEmpty()||pass1.isEmpty()||pass2.isEmpty()||Email.isEmpty()){
                var isBlank=true //비어있는가 확인
                dlg.setMessage("모든 내용을 다입력하세요")
                dlg.show()

            }
            else{
                if(pass1==pass2){
                    isSamePassword=true


                    if(isBlank==false && isSamePassword==true){

                        dlg.setTitle("Confirm")
                        dlg.setMessage("회원가입하시겠습니까")
                        dlg.setIcon(R.mipmap.ic_launcher)
                        dlg.setPositiveButton("OK",null)
                        dlg.setNegativeButton("CANCEL",null)
                        dlg.show()
                    }



             
                    
                }






            }



            var intent= Intent(this,JoinActivity::class.java)




        }






    }
}