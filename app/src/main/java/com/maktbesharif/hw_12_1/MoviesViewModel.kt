package com.maktbesharif.hw_12_1

import androidx.lifecycle.ViewModel

class MoviesViewModel: ViewModel() {

    val favoriteMovies = arrayListOf<Movies>()

    val moviesList = arrayListOf(
        Movies(R.string.equalizer_1, R.drawable.equalizer_1),
        Movies(R.string.equalizer_2, R.drawable.equalizer_2),
        Movies(R.string.john_wick_1, R.drawable.john_wick_1),
        Movies(R.string.john_wick_2, R.drawable.john_wick_2),
        Movies(R.string.john_wick_3, R.drawable.john_wick_3),
        Movies(R.string.fighter_in_the_wind, R.drawable.fighter_in_the_wind),
        Movies(R.string.taken_1, R.drawable.taken_1),
        Movies(R.string.taken_2, R.drawable.taken_2),
        Movies(R.string.taken_3, R.drawable.taken_3),
        Movies(R.string.aladdin, R.drawable.aladdin),
        Movies(R.string.arrival, R.drawable.arrival),
        Movies(R.string.born_a_champion, R.drawable.born_a_champion),
        Movies(R.string.green_book, R.drawable.green_book),
        Movies(R.string.hacksaw_ridge, R.drawable.haksaw_ridge),
        Movies(R.string.the_prestige, R.drawable.the_prestige),
        Movies(R.string.deja_vu, R.drawable.deja_vu),
        Movies(R.string.ford_vs_ferrari, R.drawable.ford_vs_ferrari),
        Movies(R.string.death_race, R.drawable.death_race),
        Movies(R.string.wanted, R.drawable.wanted),
        Movies(R.string.salt, R.drawable.salt),
        Movies(R.string.chaos, R.drawable.chaos)
    )

    fun getPosition(position: Int) {
        if(!moviesList[position].isClicked) {
            moviesList[position].isClicked = true
            favoriteMovies.add(moviesList[position])
        }
        else {
            moviesList[position].isClicked = false
            favoriteMovies.remove(moviesList[position])
        }
    }
}