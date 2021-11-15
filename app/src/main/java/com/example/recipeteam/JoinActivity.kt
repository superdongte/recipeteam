package com.example.recipeteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import android.content.DialogInterface
import android.util.Log
import android.widget.TextView
import com.example.recipeteam.user.UserInfoService
import com.example.recipeteam.user.User
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class JoinActivity : AppCompatActivity() {
    lateinit var tv1 : TextView;
    var join: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.join)

        var Edtusername= findViewById<EditText>(R.id.Edtusername)
        val Edtemail = findViewById<EditText>(R.id.EdtEmail)
        var Edtpassword = findViewById<EditText>(R.id.EdtPassword)
        var EdtConPassword = findViewById<EditText>(R.id.EdtPasswordCheck)
        var btnJoin = findViewById<Button>(R.id.btnJoin)
        var btnBehind = findViewById<Button>(R.id.btnBehind)
        var isSamePassword = false //패스워드 확인체크
        var isBlank = false // 비워져 있는지 확인
        var dlg = AlertDialog.Builder(this@JoinActivity)

        val intent = Intent(this, loginActivity::class.java)
        var gson1: Gson = GsonBuilder().setLenient().create()

        var retrofit = Retrofit.Builder()
            .baseUrl("http://10.100.204.33:8083") // 169.254.105.190/16

            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var service = retrofit.create(UserInfoService::class.java)


        btnBehind.setOnClickListener {

            startActivity(intent)
        }


        btnJoin.setOnClickListener {

            var password: String = Edtpassword.text.toString()
            //       var pass2: String = EdtConPassword.text.toString()
            var username: String = Edtusername.text.toString()
            var email: String = Edtemail.text.toString()
            var passConfirm = isSamePassword
            Log.d("result","dsdssds111111111111111111111111111111111111111")


//            if(username.isEmpty()||email.isEmpty()||password.isEmpty()||Email.isEmpty()){
//                var isBlank=true //비어있는가 확인
//                dlg.setMessage("모든 내용을 다입력하세요")
//                dlg.show()
//
//            }


            service.insertUserInfo(User(username=username, email=email,password=password,roles="ROLE_USER")).enqueue(object : Callback<User> {


                override fun onFailure(call: Call<User>, t: Throwable) {

                    tv1.text = "request 에 실패하였습니다."

                    var dialog = AlertDialog.Builder(this@JoinActivity)
                    dialog.setTitle("에러")
                    dialog.setMessage("호출실패했습니다.")
                    dialog.show()

                }
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    var result =response.body()
                    Log.d("result","dsdssds")





//                    tv1.text = response.body().toString()

                    var dialog = AlertDialog.Builder(this@JoinActivity)
                    dialog.setTitle("알림")
                    dialog.setMessage("회원가입성공")
                    dialog.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which -> startActivity(intent)
                        finish()
                    })
                }
            })
        }

    }
}