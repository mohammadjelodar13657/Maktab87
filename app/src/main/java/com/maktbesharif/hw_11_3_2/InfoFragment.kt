package com.maktbesharif.hw_11_3_2

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.maktbesharif.hw_11_3_2.databinding.FragmentInfoBinding

class InfoFragment : Fragment(R.layout.fragment_info) {

    private lateinit var binding: FragmentInfoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        binding.fullNameText.text = requireArguments().getString(RegisterFragment.KEY_FULLNAME)
        binding.usernameText.text = requireArguments().getString(RegisterFragment.KEY_USERNAME)
        binding.emailText.text = requireArguments().getString(RegisterFragment.KEY_EMAIL)
        binding.passwordText.text = requireArguments().getString(RegisterFragment.KEY_PASSWORD)
        binding.genderText.text = requireArguments().getString(RegisterFragment.KEY_GENDER)

        binding.hideInfo.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<RegisterFragment>(R.id.fragment_container_view)
            }
        }
    }
}