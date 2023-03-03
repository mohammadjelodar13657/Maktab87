package com.maktbesharif.hw_13_1

import androidx.lifecycle.ViewModel

class ColoringViewModel: ViewModel() {

    val colorPaletteList = mutableListOf<ColorsList>(
        ColorsList(R.string.fire_engine_red, 50, R.color.fire_engine_red, false),
        ColorsList(R.string.prussian_blue, 60, R.color.prussian_blue, false),
        ColorsList(R.string.xanthous, 70, R.color.xanthous, false),
        ColorsList(R.string.orange, 80, R.color.orange, false),
        ColorsList(R.string.vanilla, 90, R.color.vanilla, false),
        ColorsList(R.string.wine, 100, R.color.wine, false),
        ColorsList(R.string.spanish_orange, 110, R.color.spanish_orange, false),
        ColorsList(R.string.auburn, 120, R.color.auburn, false),
        ColorsList(R.string.dark_purple, 130, R.color.dark_purple, false),
        ColorsList(R.string.earth_yellow, 140, R.color.earth_yellow, false),
        ColorsList(R.string.eggplant, 150, R.color.eggplant, false),
        ColorsList(R.string.pakistan_green, 160, R.color.pakistan_green, false),
        ColorsList(R.string.black_bean, 170, R.color.black_bean, false),
        ColorsList(R.string.citrine, 180, R.color.citrine, false),
        ColorsList(R.string.lime_green, 190, R.color.lime_green, false),
        ColorsList(R.string.celestial_blue, 200, R.color.celestial_blue, false),
        ColorsList(R.string.red_violet, 210, R.color.red_violet, false),
        ColorsList(R.string.magneta, 220, R.color.magneta, false),
        ColorsList(R.string.mint, 230, R.color.mint, false),
        ColorsList(R.string.thulian_pink, 240, R.color.thulian_pink, false)
    )

}