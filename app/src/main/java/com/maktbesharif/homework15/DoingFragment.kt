package com.maktbesharif.homework15

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maktbesharif.homework15.databinding.FragmentDoingBinding
import com.maktbesharif.hw_13_2.tasklist.TaskAdapter
import com.maktbesharif.hw_13_2.tasklist.TaskListViewModel

class DoingFragment : Fragment(R.layout.fragment_doing) {

    val sharedViewModel by activityViewModels<TaskListViewModel>()
    private lateinit var binding: FragmentDoingBinding
    lateinit var adapter: TaskAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        binding.recyclerViewDoing.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        sharedViewModel.doingTaskListLive.observe(viewLifecycleOwner
        ) {
            adapter = TaskAdapter()
            adapter.submitList(it!!)
            binding.recyclerViewDoing.adapter = adapter
        }
    }
}