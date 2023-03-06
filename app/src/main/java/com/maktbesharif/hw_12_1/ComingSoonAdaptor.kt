package com.maktbesharif.hw_12_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ComingSoonAdaptor(private val item: ArrayList<Movies>, val getMoviePosition: (position: Int) -> Unit) :
    RecyclerView.Adapter<ComingSoonAdaptor.ViewHolder>() {

    var click = true

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text)
        val moviePicture: ImageView = itemView.findViewById(R.id.imageView)
        val favIcon: ImageView = itemView.findViewById(R.id.icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieItem = item[position]
        holder.apply {
            textView.setText(movieItem.names)
            moviePicture.setImageResource(movieItem.pics)
            favIcon.setImageResource(movieItem.favIcon)

            favIcon.setOnClickListener {
                getMoviePosition(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }

}