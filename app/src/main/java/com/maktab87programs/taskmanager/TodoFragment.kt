package com.maktab87programs.taskmanager

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maktab87programs.taskmanager.databinding.FragmentTodoBinding

class TodoFragment : Fragment(R.layout.fragment_todo), OnItemClickListener {

    private lateinit var binding: FragmentTodoBinding
    private val sharedListViewModel by activityViewModels<TaskManagerViewModel>()
    private lateinit var adapter: TaskAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        binding.recyclerViewTodo.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        sharedListViewModel.todoTaskListLive.observe(viewLifecycleOwner) {
            adapter = TaskAdapter(this)
            adapter.submitList(it)
            binding.recyclerViewTodo.adapter = adapter
        }
    }

    override fun onItemClick(item: Task) {
        val editTaskDialog = EditTaskDialog(item)
        editTaskDialog.show(parentFragmentManager, "editTaskDialog")
    }
}