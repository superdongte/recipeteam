package com.example.recipeteam

import com.example.recipeteam.user.UserInfoList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.recipeteam.user.UserInfo
import com.example.recipeteam.user.UserInfoService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConnectActivity : AppCompatActivity()
{
    lateinit var tv1 : TextView;
    lateinit var btn1 : Button;
    lateinit var btn2 : Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1 = findViewById<TextView>(R.id.tv1)
        btn1 = findViewById<Button>(R.id.btn1)
        btn2 = findViewById<Button>(R.id.btn2)

        btn1.setOnClickListener {
            request1()
        }
        btn2.setOnClickListener {
            request2()
        }
    }

    private fun request1()
    {
        val baseURL = "http://10.100.204.53:8082"
        var gson1 : Gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit
            .Builder()
            .baseUrl(baseURL)
//            .addConverterFactory(GsonConverterFactory.create(gson1))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(UserInfoService::class.java)

        service.getPeople().enqueue(object: Callback<UserInfoList>
        {
            override fun onResponse(call: Call<UserInfoList>, response: Response<UserInfoList>)
            {
                var userList1 = response.body()
                var str1=""
                for(i in 0..userList1!!.datas.size-1) {
                    str1 += ", " + userList1!!.datas.get(i).id
                    str1 += ", " + userList1!!.datas.get(i).email
                    str1 += ", " + userList1!!.datas.get(i).password
                    str1 += "," + userList1!!.datas.get(i).roles
                    str1 += ", " + userList1!!.datas.get(i).username
                }
                tv1.text = str1
//                    tv1.text = response.body().toString()
            }

            override fun onFailure(call: Call<UserInfoList>, t: Throwable)
            {
                tv1.text = "request 에 실패하였습니다."
                // 에러 메세지를 표시하는 Toast 를 추가하는 등의 에러 처리를 추가하는 것도 가능 !
            }
        })
    }

    private fun request2()
    {
        val baseURL = "http://10.100.204.53:8082"
        var gson1 : Gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit
            .Builder()
            .baseUrl(baseURL)
//            .addConverterFactory(GsonConverterFactory.create(gson1))
            .addConverterFactory(GsonConverterFactory.create(gson1))
            .build()

        val service = retrofit.create(UserInfoService::class.java)
        service.insetUserInfo(UserInfo(id=10,email="drr5rq@naver.com",password="1234", roles="ROLE_MANAGER",username="상욱"))
            .enqueue(object: Callback<UserInfo>
            {
                override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>)
                {
                    var userList1 = response.body()
                    var str1=""
                    tv1.text = str1
//                    tv1.text = response.body().toString()
                }

                override fun onFailure(call: Call<UserInfo>, t: Throwable)
                {
                    tv1.text = "request 에 실패하였습니다."
                    // 에러 메세지를 표시하는 Toast 를 추가하는 등의 에러 처리를 추가하는 것도 가능 !
                }
            });
    }
}
