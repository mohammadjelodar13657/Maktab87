package com.maktbesharif.azmoonqueez.task.createtask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maktbesharif.azmoonqueez.R
import com.maktbesharif.azmoonqueez.databinding.FragmentCreateTaskBinding
import com.maktbesharif.azmoonqueez.task.Adaptor
import com.maktbesharif.azmoonqueez.task.TaskViewModel

class CreateTaskFragment : Fragment(R.layout.fragment_create_task) {

    private lateinit var binding: FragmentCreateTaskBinding
    val taskViewModel: TaskViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        binding.button2.setOnClickListener {
            when {
                binding.todoRadioButton.isChecked -> {
                    taskViewModel.toDoStatus()
                    Toast.makeText(requireContext(), taskViewModel.checkStatus(), Toast.LENGTH_SHORT).show()

                }
                binding.doneRadioButton.isChecked -> {
                    taskViewModel.toDoStatus()
                    Toast.makeText(requireContext(), taskViewModel.checkStatus(), Toast.LENGTH_SHORT).show()

                }
                binding.doingRadioButton.isChecked -> {
                    taskViewModel.toDoStatus()
                    Toast.makeText(requireContext(), taskViewModel.checkStatus(), Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}