package com.maktbesharif.hw_12_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class Adaptor(private val item: ArrayList<Movies>, val viewModel: MoviesViewModel, val onClick: (position: Int) -> Unit) : RecyclerView.Adapter<Adaptor.ViewHolder>() {

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
        holder.apply {
            textView.setText(item[position].names)
            moviePicture.setImageResource(item[position].pics)
            favIcon.setImageResource(item[position].favIcon)

            favIcon.setOnClickListener {
                onClick(position)
//                notifyDataSetChanged()
                if (item[position].isClicked == true) {
                    favIcon.setImageResource(R.drawable.favorite_icon)
//                    notifyDataSetChanged()
//                    click = false
                } else {
                    favIcon.setImageResource(R.drawable.favorite_border_icon)
//                    notifyDataSetChanged()
//                    click = true
                }
//                notifyDataSetChanged()
            }
        }


    }

    override fun getItemCount(): Int {
        return item.size
    }

}