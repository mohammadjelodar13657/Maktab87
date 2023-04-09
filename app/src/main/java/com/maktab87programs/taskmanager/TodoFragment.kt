package com.maktab87programs.taskmanager

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.maktab87programs.taskmanager.databinding.FragmentTodoBinding

class TodoFragment : Fragment(R.layout.fragment_todo) {

    private lateinit var binding: FragmentTodoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
    }
}