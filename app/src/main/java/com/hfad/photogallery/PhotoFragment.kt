package com.hfad.photogallery

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hfad.photogallery.databinding.FragmentPhotoBinding

class PhotoFragment : Fragment(R.layout.fragment_photo) {

    private lateinit var binding: FragmentPhotoBinding
    private lateinit var adapter: FlickrPhotosAdapter
    private lateinit var viewModel: FlickrViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        viewModel = ViewModelProvider(this).get(FlickrViewModel::class.java)
        viewModel.fetchPopularPhotos()

        binding.recyclerView.adapter = adapter

        viewModel.photos.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

    }

}