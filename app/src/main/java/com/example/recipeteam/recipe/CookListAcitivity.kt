package com.example.recipeteam.recipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            Cook(1234, "cname", "cimage", "crecipe", "cookcontent")
        )


        recyclerView = findViewById(R.id.recyclerRecipeLists)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CookAdapter(cookList)
        request()
    }



    private fun request() {
        Toast.makeText(applicationContext, "success", Toast.LENGTH_SHORT).show()
        val baseURL = "http://10.100.204.69:8077"
        var gson1 : Gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit
            .Builder()
            .baseUrl(baseURL)
//            .addConverterFactory(GsonConverterFactory.create(gson1))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // val service: retrofit.create(PostService::class.java)
        val service = retrofit.create(CookService::class.java)
        service.getCookList().enqueue(object: Callback<CookList> {
            override fun onResponse(call: Call<CookList>, response: Response<CookList>) {
                var cookList1 = response.body()
                for(i in 0..cookList1!!.datas.size-1) {
                    cookList = arrayListOf(
                        Cook(cookList1!!.datas.get(i).cookid, cookList1!!.datas.get(i).cname, cookList1!!.datas.get(i).cimage
                        ,cookList1!!.datas.get(i).crecipe, cookList1!!.datas.get(i).cookcontent)
                    )
                }
               // recyclerView.adapter = CookAdapter(cookList)
            }

            override fun onFailure(call: Call<CookList>, t: Throwable) {
                return Toast.makeText(applicationContext, "android test", Toast.LENGTH_SHORT).show()
            }
        })
    }



}