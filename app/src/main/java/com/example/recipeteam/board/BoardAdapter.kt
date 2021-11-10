package com.example.recipeteam.board

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeteam.R

class BoardAdapter(private val dataSet: Array<String>) :
RecyclerView.Adapter<BoardAdapter.ViewHolder>() {
   class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
       lateinit var authimg : ImageView
       lateinit var author : TextView
       lateinit var title : TextView
       lateinit var content : TextView

       init {
           authimg = view.findViewById(R.id.postAuthorPhoto)
           author = view.findViewById(R.id.postAuthor)
           title = view.findViewById(R.id.postTitle)
           content = view.findViewById(R.id.postBody)
       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_all_posts, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.author.text = dataSet[position]
        holder.title.text = dataSet[position]
        holder.content.text = dataSet[position]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}