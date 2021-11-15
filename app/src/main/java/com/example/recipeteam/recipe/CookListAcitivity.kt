package com.example.recipeteam.recipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeteam.R
import com.example.recipeteam.board.PostActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CookListAcitivity : AppCompatActivity() {

    var cookList = ArrayList<Cook>()
    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_all_lists)

        var fcbtn = findViewById<FloatingActionButton>(R.id.fabNewCook)


        /*val cookList = arrayListOf(
            CookView("title" ,R.drawable.ic_baseline_account_circle_24),
            CookView("title" ,R.drawable.ic_baseline_account_circle_24),
            CookView("title" ,R.drawable.ic_baseline_account_circle_24),
            CookView("title" ,R.drawable.ic_baseline_account_circle_24)
        )*/

        fcbtn.setOnClickListener {
            val intent = Intent(this, RecipeRegister::class.java)
            startActivity(intent)
        }



        cookList = arrayListOf(
            Cook("cimage", "cname", "45분","cookcontent", "crecipe")
        )

        recyclerView = findViewById(R.id.recyclerRecipeLists)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CookAdapter(cookList)

        request1()
    }



    private fun request1() {
        Toast.makeText(applicationContext, "request success", Toast.LENGTH_SHORT).show()
        val baseURL = "http://172.30.1.2:8077"
        var gson1 : Gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit
            .Builder()
            .baseUrl(baseURL)
//            .addConverterFactory(GsonConverterFactory.create(gson1))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CookService::class.java)
        service.getCookList().enqueue(object: Callback<CookList> {
            override fun onResponse(call: Call<CookList>, response: Response<CookList>) {
                var cookList1 = response.body()
                Toast.makeText(applicationContext, "android response", Toast.LENGTH_SHORT).show()
                for(i in 0..cookList1!!.datas.size-1) {
                    /*cookList = arrayListOf(
                        Cook(cookList1!!.datas.get(i).cookid, cookList1!!.datas.get(i).cname, cookList1!!.datas.get(i).cimage
                        ,cookList1!!.datas.get(i).crecipe, cookList1!!.datas.get(i).cookcontent)*/
                    cookList.add(
                        Cook(cookList1!!.datas.get(i).cimage, cookList1!!.datas.get(i).cname, cookList1!!.datas.get(i).ctime,
                            cookList1!!.datas.get(i).cookcontent, cookList1!!.datas.get(i).crecipe)
                    )
                    //Log.d("text", cookList1!!.datas.get(i).cname)
                    println(cookList1!!.datas.get(i).cname)
                }
                recyclerView.adapter = CookAdapter(cookList)
            }

            override fun onFailure(call: Call<CookList>, t: Throwable) {
                return Toast.makeText(applicationContext, "android fail", Toast.LENGTH_SHORT).show()
                println("fail")
            }
        })
    }

/*

    private fun request1()
    {
        val baseURL = "http://10.100.204.69:8077"
        var gson1 : Gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit
            .Builder()
            .baseUrl(baseURL)
//            .addConverterFactory(GsonConverterFactory.create(gson1))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CookService::class.java)

        service.getCookList().enqueue(object: Callback<CookList>
        {
            override fun onResponse(call: Call<CookList>, response: Response<CookList>)
            {
                var userList1 = response.body()
                var str1=""
                */
/*for(i in 0..userList1!!.datas.size-1) {
                    str1 += ", " + userList1!!.datas.get(i).id
                    str1 += ", " + userList1!!.datas.get(i).name
                    str1 += ", " + userList1!!.datas.get(i).phone
                    str1 += "," + userList1!!.datas.get(i).grade
                    str1 += ", " + userList1!!.datas.get(i).date_time+"\n"
                }
                tv1.text = str1
//                    tv1.text = response.body().toString()*//*

            }

            override fun onFailure(call: Call<CookList>, t: Throwable)
            {
                //tv1.text = "request 에 실패하였습니다."
                // 에러 메세지를 표시하는 Toast 를 추가하는 등의 에러 처리를 추가하는 것도 가능 !
            }
        })
    }

*/

}