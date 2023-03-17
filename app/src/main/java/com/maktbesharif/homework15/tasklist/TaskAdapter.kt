package com.maktbesharif.hw_13_2.tasklist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.maktbesharif.homework15.R

class TaskAdapter(): ListAdapter<Task, TaskAdapter.CityViewHolder>(TaskDiffCallBack()) {
    class CityViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val taskName = itemView.findViewById<TextView>(R.id.taskName)
        val taskState = itemView.findViewById<TextView>(R.id.taskState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val item = getItem(position)
        with(holder) {
            taskName.text = item.name
            taskState.text = item.state.name
        }
    }
}

class TaskDiffCallBack: DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.state == newItem.state
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem
    }
}