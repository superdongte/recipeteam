package com.example.recipeteam.board

import android.content.Context
import android.media.Image
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeteam.R

class BoardAdapter(val postList: ArrayList<PostList>) :
RecyclerView.Adapter<BoardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.authimg.setImageResource(R.drawable.ic_action_account_circle_40)
        holder.author.text = postList.get(position).toString()
        holder.title.text = postList.get(position).toString()
        holder.content.text = postList.get(position).toString()
    }

    override fun getItemCount(): Int {
        return postList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val authimg = itemView.findViewById<ImageView>(R.id.postAuthorPhoto)
        val author = itemView.findViewById<TextView>(R.id.postAuthor)
        val title = itemView.findViewById<TextView>(R.id.postTitle)
        val content = itemView.findViewById<TextView>(R.id.postBody)
    }
}