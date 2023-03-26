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
import com.maktbesharif.hw_15_1.databinding.FragmentDoneBinding
import com.maktbesharif.hw_15_1.viewtask.TaskAdapter

class DoneFragment : Fragment(R.layout.fragment_done) {

    private lateinit var binding: FragmentDoneBinding
    private val sharedViewModel by activityViewModels<TaskListViewModel>()
    private lateinit var adapter: TaskAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        binding.recyclerViewDone.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        sharedViewModel.doneTaskListLive.observe(viewLifecycleOwner) {
            adapter = TaskAdapter()
            adapter.submitList(it)
            binding.recyclerViewDone.adapter = adapter
        }

    }
}