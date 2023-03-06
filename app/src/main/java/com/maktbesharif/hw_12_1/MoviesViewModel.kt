package com.maktbesharif.hw_12_1

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MoviesViewModel : ViewModel() {

    var registerStatus = false

    val name = MutableLiveData<String>("")
    val family = MutableLiveData<String>("")
    val password = MutableLiveData<String>("")
    val email = MutableLiveData<String>("")
    val userName = MutableLiveData<String>("")
    val phoneNumber = MutableLiveData<String>("")
    var uri = MutableLiveData<Uri>()

    /**
     * لیست فیلم های دلخواه
     */
    val favoriteMovies = arrayListOf<Movies>()

    /**
     * لیست فیلم هایی که به زودی منتشر می شوند
     */
    val comingSoonList = arrayListOf<Movies>(
        Movies(R.string.operation_fortune, R.drawable.operation_fortune, R.drawable.share_icon),
        Movies(R.string.john_wick_4, R.drawable.john_wick_4, R.drawable.share_icon),
        Movies(R.string.fast_x, R.drawable.fast_x, R.drawable.share_icon)
    )

    /**
     * لیست فیلم ها
     */
    val moviesList = arrayListOf(
        Movies(R.string.equalizer_1, R.drawable.equalizer_1, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.equalizer_2, R.drawable.equalizer_2, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.john_wick_1, R.drawable.john_wick_1, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.john_wick_2, R.drawable.john_wick_2, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.john_wick_3, R.drawable.john_wick_3, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.fighter_in_the_wind, R.drawable.fighter_in_the_wind, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.taken_1, R.drawable.taken_1, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.taken_2, R.drawable.taken_2, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.taken_3, R.drawable.taken_3, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.aladdin, R.drawable.aladdin, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.arrival, R.drawable.arrival, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.born_a_champion, R.drawable.born_a_champion, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.green_book, R.drawable.green_book, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.hacksaw_ridge, R.drawable.haksaw_ridge, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.the_prestige, R.drawable.the_prestige, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.deja_vu, R.drawable.deja_vu, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.ford_vs_ferrari, R.drawable.ford_vs_ferrari, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.death_race, R.drawable.death_race, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.wanted, R.drawable.wanted, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.salt, R.drawable.salt, R.drawable.favorite_border_icon, isClicked = false),
        Movies(R.string.chaos, R.drawable.chaos, R.drawable.favorite_border_icon, isClicked = false)
    )

    /**
     * کنترل برای رجیستر شدن و آزاد کردن لایک
     */
    fun getMovie(position: Int, movies: Movies) {
        if(checkRegister() == true) {
            for(movie in moviesList) {
                movie.isClickable = true
            }

            if (!movies.isClicked) {
                movies.isClicked = true
                favoriteMovies.add(movies)
            } else {
                if (favoriteMovies.size > 0) {
                    movies.isClicked = false
                    favoriteMovies.remove(movies)
                }
            }
        }
    }

    /**
     * کنترل برای پر کردن فیلد های ثبت نام
     */
    fun checkContent(): String {
        return when {
            name.value?.isEmpty()!! -> {
                registerStatus = false
                "Enter Name"
            }
            family.value?.isEmpty()!! -> {
                registerStatus = false
                "Enter Family"
            }
            email.value?.isEmpty()!! -> {
                registerStatus = false
                "Enter Email"
            }
            password.value?.isEmpty()!! -> {
                registerStatus = false
                "Enter Password"
            }
            else -> {
                registerStatus = true
                "Registration is done"
            }
        }
    }

    /**
     * کنترل برای انجام شدن ثبت نام و ازاد شدن شیر نام فیلم
     */
    fun checkRegister(): Boolean {
        return name.value?.isNotEmpty()!! && family.value?.isNotEmpty()!! && password.value?.isNotEmpty()!! && email.value?.isNotEmpty()!!
    }
}