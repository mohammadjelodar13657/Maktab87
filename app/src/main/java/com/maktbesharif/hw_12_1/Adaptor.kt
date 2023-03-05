package com.maktbesharif.hw_12_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class Adaptor(private val item: ArrayList<String>) : RecyclerView.Adapter<Adaptor.ViewHolder>() {

    var click = true

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text)
        val icon: ImageView = itemView.findViewById(R.id.icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = item[position]
        holder.icon.setOnClickListener {

            if (click == true) {
                holder.icon.setImageResource(R.drawable.favorite_icon)
                click = false
            } else {
                holder.icon.setImageResource(R.drawable.favorite_border_icon)
                click = true
            }
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }

}