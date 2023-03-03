package com.maktbesharif.hw_13_1

import androidx.lifecycle.ViewModel

class ColoringViewModel: ViewModel() {

    val colorPaletteList = arrayListOf(
        ColorsList(R.string.fire_engine_red, 150, "#d62828", false),
        ColorsList(R.string.prussian_blue, 175, "#003049", false),
        ColorsList(R.string.xanthous, 200, "#fcb322", false),
        ColorsList(R.string.orange, 225, "#f77f00", false),
        ColorsList(R.string.vanilla, 250, "#eae2b7", false),
        ColorsList(R.string.wine, 275,"#6b2c39", false),
        ColorsList(R.string.spanish_orange, 285,"#e96e25", false),
        ColorsList(R.string.auburn, 300, "#a12a31", false),
        ColorsList(R.string.dark_purple, 315, "#6b2c39", false),
        ColorsList(R.string.earth_yellow, 330, "#f1b15c", false),
        ColorsList(R.string.eggplant, 345, "#512d3d", false),
        ColorsList(R.string.pakistan_green, 360, "#004a0c", false),
        ColorsList(R.string.black_bean, 370, "#4A0000", false),
        ColorsList(R.string.citrine, 380, "#D3C312", false),
        ColorsList(R.string.lime_green, 390, "#12D332", false),
        ColorsList(R.string.celestial_blue, 400, "#1290D3", false),
        ColorsList(R.string.red_violet, 410, "#D31289", false),
        ColorsList(R.string.magneta, 420,"#FF0392", false),
        ColorsList(R.string.mint, 430, "#20BB85", false),
        ColorsList(R.string.thulian_pink, 440, "#DD6DA3", false)
    )

}