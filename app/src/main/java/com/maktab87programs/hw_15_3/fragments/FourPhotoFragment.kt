package com.maktab87programs.hw_15_3.fragments

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.maktab87programs.hw_15_3.R
import com.maktab87programs.hw_15_3.view_models.MyViewModel
import com.maktab87programs.hw_15_3.databinding.FragmentFourPhotoBinding

class FourPhotoFragment : Fragment(R.layout.fragment_four_photo) {

    private lateinit var binding: FragmentFourPhotoBinding
    private val myViewModel: MyViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        binding.imageUrl1 = myViewModel.imageUrl1
        binding.imageUrl2 = myViewModel.imageUrl2
        binding.imageUrl3 = myViewModel.imageUrl3
        binding.imageUrl4 = myViewModel.imageUrl4
    }
}
