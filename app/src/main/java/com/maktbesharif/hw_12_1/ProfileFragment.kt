package com.maktbesharif.hw_12_1

import android.app.Activity.RESULT_OK
import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maktbesharif.hw_12_1.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val sharedViewModel by activityViewModels<MoviesViewModel>()

    private lateinit var binding: FragmentProfileBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.viewModel = sharedViewModel
        binding.lifecycleOwner = this

        binding.register.setOnClickListener {
            Log.e(TAG, "onViewCreated: ${sharedViewModel.registerStatus}", )
            if(sharedViewModel.registerStatus == false) {
                Toast.makeText(requireContext(), sharedViewModel.checkContent(), Toast.LENGTH_SHORT).show()
            } else {
                view.findNavController().navigate(R.id.action_profileFragment_to_registeredInformationFragment)
            }
        }

        val register =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val selectImageUri: Uri? = result.data?.data
                    if (selectImageUri != null) {
                        sharedViewModel.uri.value = selectImageUri
                        binding.imageView.setImageURI(selectImageUri)
                    }
                }
            }

        binding.imageView.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            register.launch(intent)
        }
    }

}