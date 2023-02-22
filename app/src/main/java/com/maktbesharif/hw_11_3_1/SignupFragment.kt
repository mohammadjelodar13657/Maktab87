package com.maktbesharif.hw_11_3_1

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import com.google.android.material.snackbar.Snackbar
import com.maktbesharif.hw_11_3_1.databinding.FragmentSignupBinding

class SignupFragment : Fragment(R.layout.fragment_signup) {

    companion object {
        val KEY_USERNAME_SIGNUP = "KEY_USERNAME"
        val KEY_PASSWORD_SIGNUP = "KEY_PASSWORD"
    }

    private lateinit var binding: FragmentSignupBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val signupViewModel: SignupViewModel by viewModels()

        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.viewModel = signupViewModel

        signupViewModel.username.value = requireArguments().getString(LoginFragment.KEY_USERNAME)
        Log.e("user", "${requireArguments().getString(LoginFragment.KEY_USERNAME)!!}: ", )
        signupViewModel.password.value = requireArguments().getString(LoginFragment.KEY_PASSWORD)

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
                parentFragmentManager.commit {
                    val bundle = bundleOf(
                        KEY_USERNAME_SIGNUP to signupViewModel.username.value,
                        KEY_PASSWORD_SIGNUP to signupViewModel.password.value
                    )
                    setReorderingAllowed(true)
                    addToBackStack("A")
                    replace<LoginFragment>(R.id.fragment_container_view, args = bundle)

                }
            }
        }
    }
}