package com.example.recipeteam

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.recipeteam.board.BoardActivity
import com.example.recipeteam.user.LoginReqDto
import com.example.recipeteam.user.LoginService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class loginActivity : AppCompatActivity() {
    var login:LoginReqDto? = null
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
        val intent=Intent(this,MainActivity::class.java)

        var retrofit = Retrofit.Builder()
            .baseUrl("http://10.100.204.33:8083")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var loginService: LoginService = retrofit.create(LoginService::class.java)



        btnJoin.setOnClickListener{
            val intent=Intent(this,JoinActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener{
            var username = InputId.text.toString()
            var password = InputPassword.text.toString()

            Log.e("Login",username)
            Log.e("비밀번호는",password)

            loginService.requestLogin(username, password).enqueue(object: Callback<LoginReqDto> {
                override fun onFailure(call: Call<LoginReqDto>, t: Throwable) {

                    var dialog = AlertDialog.Builder(this@loginActivity)
                    dialog.setTitle("에러")
                    dialog.setMessage("호출실패했습니다.")
                    dialog.show()
                }

                override fun onResponse(call: Call<LoginReqDto>, response: Response<LoginReqDto>) {
                    login = response.body()
                    var headers= response.headers()
                    Log.d("LOGIN","username: "+login?.msg)
                    Log.d("LOGIN","password : "+login?.code)
                    var userList1 = response.body()
                    var dialog = AlertDialog.Builder(this@loginActivity)
                    dialog.setTitle(login?.msg)
                    dialog.setMessage(login?.code)
                    dlg.setPositiveButton("확인",DialogInterface.OnClickListener { dialog, which ->
                        startActivity(intent)
                        finish()

                    })

                    dialog.show()
                }
            })
        }
    }






//        //// 쉐어드로부터 저장된 id, pw 가져오기
//        btnLogin.setOnClickListener {
//            val sharedPreference = getSharedPreferences("file name", Context.MODE_PRIVATE)
//            var savedId=sharedPreference.getString("id","")
//            var savedPassword=sharedPreference.getString("pw","")
//
//
//            var pass1:String=InputId.text.toString()
//            var pass2:String=InputPassword.text.toString()
//
//
//
//           if(pass1 == savedId && pass2 == savedPassword){
//                // 로그인 성공 다이얼로그 보여주기
//               val intent= Intent(this, MainActivity::class.java)
//               intent.putExtra("savedId", savedId)
//               startActivity(intent)
//            }
//            else{
//                // 로그인 실패 다이얼로그 보여주기
//                dlg.setTitle("Error")
//                dlg.setMessage("아이디 혹은 비밀번호 틀렸습니다")
//                dlg.setIcon(R.mipmap.ic_launcher)
//               dlg.show()
//            }
//        }
        





}
