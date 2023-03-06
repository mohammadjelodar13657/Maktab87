package com.maktbesharif.hw_12_1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val moviesViewModel: MoviesViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val adaptor = Adaptor(moviesViewModel.moviesList, moviesViewModel) { position ->
            moviesViewModel.getPosition(
                position
            )
        }
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3) // number of tile in one row
        recyclerView.adapter = adaptor
    }
}