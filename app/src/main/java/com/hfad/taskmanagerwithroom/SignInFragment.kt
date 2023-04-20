package com.hfad.taskmanagerwithroom

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.hfad.taskmanagerwithroom.databinding.FragmentSigninBinding

class SignInFragment : Fragment(R.layout.fragment_signin) {

    private lateinit var binding: FragmentSigninBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
    }
}