package com.maktbesharif.hw_15_1.tabbedfragments

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maktbesharif.hw_15_1.viewtask.TaskListViewModel
import com.maktbesharif.hw_15_1.R
import com.maktbesharif.hw_15_1.databinding.FragmentTodoBinding
import com.maktbesharif.hw_15_1.viewtask.TaskAdapter

class TodoFragment : Fragment(R.layout.fragment_todo) {

    private lateinit var binding: FragmentTodoBinding
    private val sharedListViewModel by activityViewModels<TaskListViewModel>()
    private lateinit var adapter: TaskAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        binding.recyclerViewTodo.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        sharedListViewModel.todoTaskListLive.observe(viewLifecycleOwner) {
            adapter = TaskAdapter()
            adapter.submitList(it)
            binding.recyclerViewTodo.adapter = adapter
        }
    }
}