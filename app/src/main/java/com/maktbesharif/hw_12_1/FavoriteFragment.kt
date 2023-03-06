package com.maktbesharif.hw_12_1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoriteFragment : Fragment(R.layout.fragment_fovorite) {

    private val sharedViewModel by activityViewModels<MoviesViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.favoriteRecyclerView)
        val adaptor = Adaptor(sharedViewModel.favoriteMovies) { position, movies ->
            sharedViewModel.getMovie(
                position, movies
            )
            recyclerView.adapter?.notifyDataSetChanged()
        }
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = adaptor
    }

}