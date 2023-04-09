package com.maktab87programs.taskmanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.maktab87programs.taskmanager.databinding.FragmentDoingBinding

class DoingFragment : Fragment(R.layout.fragment_doing) {

    private lateinit var binding: FragmentDoingBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
    }
}