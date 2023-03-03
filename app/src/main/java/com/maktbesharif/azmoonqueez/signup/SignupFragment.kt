package com.maktbesharif.azmoonqueez.signup

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.maktbesharif.azmoonqueez.R
import com.maktbesharif.azmoonqueez.databinding.FragmentSignupBinding
import com.maktbesharif.azmoonqueez.login.LoginFragment
import com.maktbesharif.azmoonqueez.login.LoginFragment.Companion.RESULT
import com.maktbesharif.azmoonqueez.login.LoginFragmentDirections
import com.maktbesharif.azmoonqueez.signup.SignupViewModel


class SignupFragment : Fragment(R.layout.fragment_signup) {

    companion object {
        val KEY_USERNAME_SIGNUP = "KEY_USERNAME"
        val KEY_PASSWORD_SIGNUP = "KEY_PASSWORD"
    }

    private lateinit var binding: FragmentSignupBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val signupViewModel: SignupViewModel by viewModels()
        val args: SignupFragmentArgs by navArgs()

        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.viewModel = signupViewModel

        signupViewModel.username.value = args.username
        signupViewModel.password.value = args.password

        binding.signUp2.setOnClickListener {

            signupViewModel.username.value = binding.userNameSignup.text.toString()
            signupViewModel.password.value = binding.passwordSignup.text.toString()


            Snackbar.make(
                view,
                signupViewModel.checkSignupStatus(),
                Snackbar.LENGTH_SHORT
            )
                .setTextColor(Color.parseColor("#ffffff"))
                .setBackgroundTint(Color.parseColor("#003459"))
                .setAction("Ok") {}
                .show()
            if (signupViewModel.status) {
                setFragmentResult(LoginFragment.RESULT, bundleOf("bundle" to "ok"))
                Navigation.findNavController(view).navigate(
                    SignupFragmentDirections.actionSignupFragmentToLoginFragment(
                        signupViewModel.username.value!!,
                        signupViewModel.password.value!!
                    )
                )
            }
        }
    }
}