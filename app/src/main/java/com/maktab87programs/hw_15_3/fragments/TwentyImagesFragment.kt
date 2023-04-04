package com.maktab87programs.hw_15_3.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maktab87programs.hw_15_3.view_models.PhotoListViewModel
import com.maktab87programs.hw_15_3.R
import com.maktab87programs.hw_15_3.adapters.TwentyImageAdapter
import com.maktab87programs.hw_15_3.databinding.FragmentTwentyImagesBinding

class TwentyImagesFragment : Fragment(R.layout.fragment_twenty_images) {

    private lateinit var binding: FragmentTwentyImagesBinding
    val url = "https://picsum.photos/v2/list?limit=20"
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TwentyImageAdapter
    private val okhttpViewModel: PhotoListViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        okhttpViewModel.run(url)
        okhttpViewModel.image.observe(viewLifecycleOwner) {
            Log.e(TAG, "image: ${it}", )
            recyclerView = binding.recyclerView
            adapter = TwentyImageAdapter(it)
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
            recyclerView.adapter = adapter
        }
    }
}