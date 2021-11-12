package com.example.recipeteam.recipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_all_lists)
        var flcbtn = findViewById<FloatingActionButton>(R.id.fabNewCook)

        /*val cookList = arrayListOf(
            CookView("title" ,R.drawable.ic_baseline_account_circle_24),
            CookView("title" ,R.drawable.ic_baseline_account_circle_24),
            CookView("title" ,R.drawable.ic_baseline_account_circle_24),
            CookView("title" ,R.drawable.ic_baseline_account_circle_24)
        )*/

        flcbtn.setOnClickListener {
            val intent = Intent(this, RecipeRegister::class.java)
            startActivity(intent)
        }

        cookList = arrayListOf(
            Cook(1234, "cname", "cimage", "crecipe", "cookcontent")
        )

        var recyclerView : RecyclerView = findViewById(R.id.recyclerRecipeLists)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CookAdapter(cookList)
    }


    private fun request() {
        val baseURL = "http://192.168.43.66:8077"
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
            }

            override fun onFailure(call: Call<CookList>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }


}