package com.maktbesharif.hw_11_3_1

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import com.google.android.material.snackbar.Snackbar
import com.maktbesharif.hw_11_3_1.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    companion object {
        val KEY_USERNAME = "KEY_USERNAME"
        val KEY_PASSWORD = "KEY_PASSWORD"
    }

    val loginViewModel: LoginViewModel by viewModels()

    private lateinit var binding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.viewModel = loginViewModel

//        binding.username = getArguments()?.getString(SignupFragment.KEY_USERNAME_SIGNUP)
        if(arguments?.getString(SignupFragment.KEY_USERNAME_SIGNUP) != null && arguments?.getString(SignupFragment.KEY_PASSWORD_SIGNUP) != null) {
            loginViewModel.username.value =
                getArguments()?.getString(SignupFragment.KEY_USERNAME_SIGNUP)
//        binding.password = getArguments()?.getString(SignupFragment.KEY_PASSWORD_SIGNUP)
            loginViewModel.password.value =
                getArguments()?.getString(SignupFragment.KEY_PASSWORD_SIGNUP)
        }

        binding.login.setOnClickListener {
            Snackbar.make(
                view,
                checkLoginStatus(),
                Snackbar.LENGTH_SHORT
            )
                .setTextColor(Color.parseColor("#ffffff"))
                .setBackgroundTint(Color.parseColor("#003459"))
                .setAction("Ok") {}
                .show()
        }

        binding.signup.setOnClickListener {

            val username = binding.userNameLogin.text.toString()
            Log.e("userlogin", "${binding.userNameLogin.text}: ")
            val password = binding.passwordLogin.text.toString()

            parentFragmentManager.commit {
                val bundle = bundleOf(KEY_USERNAME to username, KEY_PASSWORD to password)
                setReorderingAllowed(true)
                addToBackStack("A")
                add<SignupFragment>(R.id.fragment_container_view, args = bundle)
            }
        }

//        lifecycle.addObserver(loginViewModel)
    }

    fun checkLoginStatus(): String {
        return if (binding.userNameLogin.text.toString().isEmpty()) {
            "Enter username"
        }
        else if (binding.passwordLogin.text.toString().isEmpty()) {
            "Enter password"
        } else if(loginViewModel.username.value?.isEmpty()!! || loginViewModel.password.value?.isEmpty()!!) {
            "No account"
        } else if (loginViewModel.username.value == binding.userNameLogin.text.toString() && loginViewModel.password.value == binding.passwordLogin.text.toString()) {
            "Login successfully"
        } else {
            "Wrong username or password"
        }
    }

}