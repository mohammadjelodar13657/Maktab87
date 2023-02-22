package com.maktbesharif.hw_11_3_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.viewModels
import com.maktbesharif.hw_11_3_2.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(R.layout.fragment_register) {

    companion object {
        val KEY_FULLNAME = "KEY_FULLNAME"
        val KEY_USERNAME = "KEY_USERNAME"
        val KEY_EMAIL = "KEY_EMAIL"
        val KEY_PASSWORD = "KEY_PASSWORD"
        val KEY_GENDER = "KEY_GENDER"
    }

    private lateinit var binding: FragmentRegisterBinding
    val registerViewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        binding.register.setOnClickListener {

            registerViewModel.fullName = binding.fullName.text.toString()
            registerViewModel.username = binding.username.text.toString()
            registerViewModel.email = binding.email.text.toString()
            registerViewModel.password = binding.password.text.toString()
            registerViewModel.reTypePassword = binding.reTypePassword.text.toString()
            val radioId = binding.radioGroup.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(radioId)
            val gender = radioButton.text.toString()
            registerViewModel.gender = gender

            Toast.makeText(context, registerViewModel.checkDataStatus(), Toast.LENGTH_SHORT).show()
        }

        binding.showInfo.setOnClickListener {
            val bundle = bundleOf(
                KEY_FULLNAME to registerViewModel.fullName,
                KEY_USERNAME to registerViewModel.username,
                KEY_EMAIL to registerViewModel.email,
                KEY_PASSWORD to registerViewModel.password,
                KEY_GENDER to registerViewModel.gender
            )
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<InfoFragment>(R.id.fragment_container_view, args = bundle)
            }
        }
    }
}