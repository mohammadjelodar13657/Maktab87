package com.maktbesharif.hw_13_1

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maktbesharif.hw_13_1.databinding.FragmentColoringBinding

class ColoringFragment : Fragment() {

    private lateinit var binding: FragmentColoringBinding
    val coloringViewModel: ColoringViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_coloring, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adaptor = Adaptor(coloringViewModel.colorPaletteList)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        recyclerView.adapter = adaptor
        return view
    }
}