package com.maktab87programs.taskmanager

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.maktab87programs.taskmanager.databinding.FragmentDoneBinding

class DoneFragment : Fragment(R.layout.fragment_done) {

    private lateinit var binding: FragmentDoneBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
    }
}