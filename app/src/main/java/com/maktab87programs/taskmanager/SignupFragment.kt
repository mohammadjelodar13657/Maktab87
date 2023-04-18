package com.maktab87programs.taskmanager

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.maktab87programs.taskmanager.databinding.FragmentSignupBinding

class SignupFragment : Fragment(R.layout.fragment_signup) {

    private lateinit var binding: FragmentSignupBinding
    private val sharedViewModel by activityViewModels<LoginViewModel>()
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = viewLifecycleOwner
        binding.signupViewModel = sharedViewModel

        val view = binding.constraint

        binding.btnSignup.setOnClickListener {
            binding.apply {
                when(sharedViewModel.checkFields()) {
                    0 -> {
                        sharedViewModel.addUserToList()
                        createSnackBar(view, "Register is successful")
                    }
                    1 -> {
                        createSnackBar(view, "This username is registered before")
                    }
                    2 -> {
                        firstNameTv.apply {
                            error = sharedViewModel.result.value
                            requestFocus()
                        }
                    }
                    3 -> {
                        lastNameTv.apply {
                            error = sharedViewModel.result.value
                            requestFocus()
                        }
                    }
                    4 -> {
                        userNameTv.apply {
                            error = sharedViewModel.result.value
                            requestFocus()
                        }
                    }
                    5 -> {
                        emailTv.apply {
                            error = sharedViewModel.result.value
                            requestFocus()
                        }
                    }
                    6 -> {
                        passwordNameEt.apply {
                            error = sharedViewModel.result.value
                            requestFocus()
                        }
                    }
                }
            }
        }
    }

    fun createSnackBar(view: View, text: String) {
        val snackBar = Snackbar.make(view, text, Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction("Login") {
            navController = view.findNavController()
            navController.navigate(R.id.action_signupFragment_to_loginFragment)
        }
        snackBar.setActionTextColor(Color.WHITE)
        snackBar.setBackgroundTint(Color.BLACK).show()
    }
}