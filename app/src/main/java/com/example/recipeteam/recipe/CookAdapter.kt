package com.example.recipeteam.recipe

import android.content.Intent
import android.os.Parcel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeteam.R
import com.example.recipeteam.RecipeDetail

class CookAdapter(val cookList: ArrayList<Cook>) : RecyclerView.Adapter<CookAdapter.CustomViewHolder>() {


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
        holder.ccontent.text = cookList.get(position).cookcontent

        holder.itemView.setOnClickListener {

            var intent = Intent(holder.itemView?.context, RecipeDetail::class.java)
            intent.putExtra("cname", holder.cname.text)
            intent.putExtra("ccontent", holder.ccontent.text)
            //intent.putParcelableArrayListExtra("cookList", cookList)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return cookList.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cname = itemView.findViewById<TextView>(R.id.recipe_name)
        val cimg = itemView.findViewById<ImageView>(R.id.recipe_img)
        val ccontent = itemView.findViewById<TextView>(R.id.recipe_content)





    }



}