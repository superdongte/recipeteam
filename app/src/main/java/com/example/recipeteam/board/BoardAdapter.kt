package com.example.recipeteam.board

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeteam.R

class BoardAdapter(val postList: ArrayList<Post>) :
RecyclerView.Adapter<BoardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.board_post_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.authimg.setImageResource(R.drawable.ic_action_account_circle_40)
        holder.author.text = postList.get(position).author
        holder.title.text = postList.get(position).title
        holder.content.text = postList.get(position).content

        holder.itemView.setOnClickListener {
            var intent = Intent(holder.itemView?.context, BoardDetail::class.java)
            intent.putExtra("author", holder.author.text)
            intent.putExtra("title", holder.title.text)
            intent.putExtra("content", holder.content.text)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }

    }

    override fun getItemCount(): Int {
        return postList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val authimg = itemView.findViewById<ImageView>(R.id.postImg)
        val author = itemView.findViewById<TextView>(R.id.postAuthor)
        val title = itemView.findViewById<TextView>(R.id.postTitle)
        val content = itemView.findViewById<TextView>(R.id.postBody)
    }
}