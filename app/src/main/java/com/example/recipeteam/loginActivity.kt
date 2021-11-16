package com.example.recipeteam

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.recipeteam.user.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class loginActivity : AppCompatActivity() {
    var loginReqDto:LoginReqDto? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        var Inputusername=findViewById<EditText>(R.id.Edtusername)
        var InputPassword=findViewById<EditText>(R.id.EdtPassword)
        var btnJoin=findViewById<Button>(R.id.btnJoin)
        var btnLogin=findViewById<Button>(R.id.btnLogin)
        var dlg= AlertDialog.Builder(this@loginActivity)
        var IdCheck=false
        var PassCheck=false
        val intent=Intent(this,MainActivity::class.java)
        val intent2= Intent(this,loginActivity::class.java)
        var gson1 : Gson = GsonBuilder().setLenient().create()

        var retrofit = Retrofit.Builder()
            .baseUrl("http://172.30.1.2:8077")
            .addConverterFactory(NullOnEmptyConverterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var loginService: LoginService = retrofit.create(LoginService::class.java)



        btnJoin.setOnClickListener{
            val intent=Intent(this,JoinActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener{
            var username = Inputusername.text.toString()
            var password = InputPassword.text.toString()


            loginService.requestLogin(LoginReqDto(username = username, password = password, msg="", code="",roles="")).enqueue(object: Callback<LoginReqDto> {

                override fun onResponse(call: Call<LoginReqDto>, response: Response<LoginReqDto>) {
                    loginReqDto= response.body()
                    var headers= response.headers()
                    var token = headers.get("Authorization")
                    Log.d("토큰은", token.toString())
                    var dialog = AlertDialog.Builder(this@loginActivity)
                    dialog.setTitle(loginReqDto?.username)
                    dialog.setMessage(loginReqDto?.password)

                    if(token != null){
                        Log.d("body는",loginReqDto.toString())

                        dialog.setTitle("어서오세요")
                        dialog.setMessage("요리하러갑시다.")
                        dialog.setPositiveButton("확인",DialogInterface.OnClickListener { dialog, which ->
                            intent.putExtra("username", username)
                            startActivity(intent)
                            finish()
                        })
                    }else{
                        dialog.setTitle("로그인에 실패하셨습니다")
                        dialog.setMessage("아이디나 비밀번호를 확인해주세요")
                        dialog.setNegativeButton("확인",DialogInterface.OnClickListener { dialog, which ->
                            startActivity(intent2)
                            finish()
                        })
                    }
                    dialog.show()
                }

                override fun onFailure(call: Call<LoginReqDto>, t: Throwable) {
                    t.printStackTrace();
                    t.message?.let { it1 -> Log.e("Login", it1) }
                    Log.e("Login", username);
                    Log.e("password",password)
                    Log.d("login","msg: "+loginReqDto?.username)
                    Log.d("login","code : "+loginReqDto?.password)
                    var dialog = AlertDialog.Builder(this@loginActivity)
                    dialog.setTitle("에러")
                    dialog.setMessage("호출실패했습니다.")
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
