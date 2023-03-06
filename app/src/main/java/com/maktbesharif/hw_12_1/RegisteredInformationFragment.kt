package com.maktbesharif.hw_12_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.maktbesharif.hw_12_1.databinding.FragmentRegisteredInformationBinding

class RegisteredInformationFragment : Fragment(R.layout.fragment_registered_information) {

    private val sharedViewModel by activityViewModels<MoviesViewModel>()
    private lateinit var binding: FragmentRegisteredInformationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.viewModel = sharedViewModel
        binding.lifecycleOwner = this

        binding.imageView.setImageURI(sharedViewModel.uri.value)
    }
}