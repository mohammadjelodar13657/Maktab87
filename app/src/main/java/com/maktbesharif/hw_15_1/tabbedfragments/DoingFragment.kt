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
import com.maktbesharif.hw_15_1.databinding.FragmentDoingBinding
import com.maktbesharif.hw_15_1.viewtask.TaskAdapter

class DoingFragment : Fragment(R.layout.fragment_doing) {

    private lateinit var binding: FragmentDoingBinding
    private val sharedViewModel by activityViewModels<TaskListViewModel>()
    private lateinit var adapter: TaskAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        binding.recyclerViewDoing.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        sharedViewModel.doingTaskListLive.observe(viewLifecycleOwner) {
            adapter = TaskAdapter()
            adapter.submitList(it)
            binding.recyclerViewDoing.adapter = adapter
        }

    }
}