package com.maktab87programs.taskmanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.maktab87programs.taskmanager.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    private lateinit var binding: FragmentWelcomeBinding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        navController = view.findNavController()

        binding.btnLogin.setOnClickListener {
            navController.navigate(R.id.action_welcomeFragment_to_loginFragment)
        }

        binding.btSignup.setOnClickListener {
            navController.navigate(R.id.action_welcomeFragment_to_signupFragment)
        }


    }
}