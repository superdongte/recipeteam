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
        holder.bauthor.text = postList.get(position).bauthor
        holder.btitle.text = postList.get(position).btitle
        holder.bcontent.text = postList.get(position).bcontent
        holder.buserid.text = postList.get(position).userid

        holder.itemView.setOnClickListener {
            var intent = Intent(holder.itemView?.context, BoardDetail::class.java)
            intent.putExtra("author", holder.bauthor.text)
            intent.putExtra("title", holder.btitle.text)
            intent.putExtra("content", holder.bcontent.text)
            intent.putExtra("username", holder.buserid.text)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }

    }

    override fun getItemCount(): Int {
        return postList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val authimg = itemView.findViewById<ImageView>(R.id.postImg)
        val bauthor = itemView.findViewById<TextView>(R.id.postAuthor)
        val btitle = itemView.findViewById<TextView>(R.id.postTitle)
        val bcontent = itemView.findViewById<TextView>(R.id.postBody)
        var buserid = itemView.findViewById<TextView>(R.id.postuid)
    }
}