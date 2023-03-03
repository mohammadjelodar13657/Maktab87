package com.maktbesharif.hw_13_1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class Adaptor(private val item: ArrayList<ColorsList>): RecyclerView.Adapter<Adaptor.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.color_palette)
        val layout: ConstraintLayout = itemView.findViewById(R.id.constraint)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder (
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            textView.setText(item[position].name)
            layout.setBackgroundColor(Color.parseColor(item[position].color))
            layout.layoutParams.height = item[position].height
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }
}