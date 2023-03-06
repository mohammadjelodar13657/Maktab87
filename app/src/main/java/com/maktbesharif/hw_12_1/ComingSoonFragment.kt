package com.maktbesharif.hw_12_1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ComingSoonFragment : Fragment(R.layout.fragment_coming_soon) {

    private val sharedViewModel by activityViewModels<MoviesViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.comingSoonRecyclerView)
        val comingSoonAdaptor = ComingSoonAdaptor(sharedViewModel.comingSoonList) { position ->
            getMoviePosition(
                position
            )
        }
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        recyclerView.adapter = comingSoonAdaptor
    }

    fun getMoviePosition(position: Int) {
        if (sharedViewModel.checkRegister()) {
            val intent = Intent(Intent.ACTION_SEND)
            val name = getString(sharedViewModel.comingSoonList[position].names)
            intent.putExtra(Intent.EXTRA_TEXT,name)
            intent.type = "text/plain"
            startActivity(intent)
        } else Toast.makeText(requireContext(), "Register First please", Toast.LENGTH_SHORT).show()
    }
}