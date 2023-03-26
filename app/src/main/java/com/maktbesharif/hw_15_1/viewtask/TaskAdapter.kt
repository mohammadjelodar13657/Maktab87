package com.maktbesharif.hw_15_1.viewtask

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.maktbesharif.hw_15_1.R
import com.maktbesharif.hw_15_1.Task
import com.maktbesharif.hw_15_1.databinding.ItemBinding

class TaskAdapter: ListAdapter<Task, TaskAdapter.TaskViewHolder>(TaskDiffCallBack()) {

    private lateinit var binding: ItemBinding

    class TaskViewHolder(binding: ItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = getItem(position)
        with(holder) {
            binding.taskName.text = item.name
            binding.taskNumber.text = item.state.name
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