package com.example.recipeteam.recipe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeteam.R

class CookAdapter(val cookList: ArrayList<CookView>) : RecyclerView.Adapter<CookAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CookAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item_list, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CookAdapter.CustomViewHolder, position: Int) {
        holder.cimg.setImageResource(R.drawable.ic_baseline_account_circle_24)
        holder.cname.text = cookList.get(position).cname
    }

    override fun getItemCount(): Int {
        return cookList.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cname = itemView.findViewById<TextView>(R.id.recipe_name)
        val cimg = itemView.findViewById<ImageView>(R.id.recipe_img)


    }


}