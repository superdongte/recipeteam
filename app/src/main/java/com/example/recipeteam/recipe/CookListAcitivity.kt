package com.example.recipeteam.recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeteam.R

class CookListAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_all_lists)

        val cookList = arrayListOf(
            CookView("title" ,R.drawable.ic_baseline_account_circle_24),
            CookView("title" ,R.drawable.ic_baseline_account_circle_24),
            CookView("title" ,R.drawable.ic_baseline_account_circle_24),
            CookView("title" ,R.drawable.ic_baseline_account_circle_24)
        )

        var recyclerView : RecyclerView = findViewById(R.id.recyclerRecipeLists)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CookAdapter(cookList)
    }
}