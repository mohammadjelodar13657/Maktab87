package com.maktab87programs.taskmanager

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.maktab87programs.taskmanager.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    object Key {
        const val USER_NAME = "username"
        const val STATUS = "status"
    }

    private lateinit var binding: FragmentLoginBinding
    private val sharedViewModel by activityViewModels<LoginViewModel>()
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.loginViewModel = sharedViewModel

        binding.signupTv.setOnClickListener {
            navController = view.findNavController()
            navController.navigate(R.id.action_loginFragment_to_signupFragment)
        }

        binding.btnLogin.setOnClickListener {
//            Log.e("TAG", "onViewCreated: ${sharedViewModel.loginUserName.value}", )
//            Log.e("TAG", "onViewCreated: ${sharedViewModel.loginPassword.value}", )
            Log.e("TAG", "uer check: ${sharedViewModel.userList[0].userName}", )
            binding.apply {
                when(sharedViewModel.checkLogin()) {
                    0 -> {
                        userNameEt.apply {
                            error = "Enter username"
                            requestFocus()

                        }
                    }
                    1 -> {
                        passwordEt.apply {
                            error = "Enter password"
                            requestFocus()
                        }
                    }
                    2 -> {
                        navigateTaskList(sharedViewModel.admin.userName, "Admin")
                    }
                    3 -> {
                        navigateTaskList(sharedViewModel.loginUserName.value, "User")
                    }
                    4 -> {
                        createSnackBar(view, "Not registered")
                    }
                }
            }
        }
    }

    fun navigateTaskList(name: String?, status: String) {
        val intent = Intent(activity, TaskManagerActivity::class.java)
        with(intent) {
            putExtra(Key.USER_NAME, name)
            putExtra(Key.STATUS, status)
        }
        startActivity(intent)
    }

    fun createSnackBar(view: View, text: String) {
        val snackBar = Snackbar.make(view, text, Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction("Signup") {
            navController = view.findNavController()
            navController.navigate(R.id.action_loginFragment_to_signupFragment)
        }
        snackBar.setActionTextColor(Color.WHITE)
        snackBar.setBackgroundTint(Color.BLACK).show()
    }
}