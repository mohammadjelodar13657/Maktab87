package com.maktab87programs.taskmanager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.maktab87programs.taskmanager.databinding.ItemBinding

class TaskAdapter(private val listener: OnItemClickListener): ListAdapter<Task, TaskAdapter.TaskViewHolder>(TaskDiffCallBack()){

    private lateinit var binding: ItemBinding

    class TaskViewHolder(binding: ItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = getItem(position)
        val x = item.title.first()
        with(holder) {
            binding.title.text = item.title
            binding.description.text = item.description
            binding.state.text = item.state
            binding.date.text = item.date
            binding.time.text = item.time
            binding.icon.text = item.title.first().toString()
            binding.itemId.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }
}

class TaskDiffCallBack(): DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.state == newItem.state
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem
    }
}