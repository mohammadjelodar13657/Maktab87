package com.maktbesharif.azmoonqueez.login

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.maktbesharif.azmoonqueez.R
import com.maktbesharif.azmoonqueez.databinding.FragmentLoginBinding
import com.maktbesharif.azmoonqueez.signup.SignupFragment
import com.maktbesharif.azmoonqueez.signup.SignupFragmentArgs

class LoginFragment : Fragment(R.layout.fragment_login) {

    companion object {
        const val RESULT = "RESULT_OK"
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
        val args: LoginFragmentArgs by navArgs()



        loginViewModel.showSnackbar.observe(viewLifecycleOwner, Observer {
            Snackbar.make(
                view,
                it,
                Snackbar.LENGTH_SHORT
            )
                .setTextColor(Color.parseColor("#ffffff"))
                .setBackgroundTint(Color.parseColor("#003459"))
                .setAction("Ok") {}
                .show()
        })

        setFragmentResultListener(
            RESULT
        ) {_, _ ->
            loginViewModel.signupUsername.value = args.signupUsername
            loginViewModel.signupPassword.value = args.signupPassword
            Log.e("TAG", "onViewCreated: ${args.signupUsername}    ${args.signupPassword}")
        }

        binding.signup.setOnClickListener {

            Navigation.findNavController(view).navigate(
                LoginFragmentDirections.actionLoginFragmentToSignupFragment(
                    loginViewModel.username.value!!,
                    loginViewModel.password.value!!
                )
            )
        }
    }
}