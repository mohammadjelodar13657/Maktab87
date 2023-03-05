package com.maktbesharif.hw_13_1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ColoringFragment : Fragment(){
    private val coloringViewModel: ColoringViewModel by viewModels()
    private lateinit var adaptor: Adaptor
    @SuppressLint("NotifyDataSetChanged")
    private val runnable = Runnable {
        coloringViewModel.delayColorChange()
        adaptor.notifyDataSetChanged()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_coloring, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        adaptor = Adaptor(coloringViewModel.colorPaletteList) { position, adaptorView ->
            getPosition(
                position, adaptorView
            )
        }
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        recyclerView.adapter = adaptor
        return view
    }

    private fun getPosition(position: Int, adaptorView: View) {
        val colorID = coloringViewModel.colorPaletteList[position].bgColor
        for(i in coloringViewModel.colorPaletteList.indices) {
            coloringViewModel.colorPaletteList[i].textColor = colorID
        }

        coloringViewModel.colorPaletteList.removeAt(position)

        adaptorView.handler.postDelayed(runnable, 5000)
    }
}