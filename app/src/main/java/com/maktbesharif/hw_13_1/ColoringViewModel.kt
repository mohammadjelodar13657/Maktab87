package com.maktbesharif.hw_13_1

import androidx.lifecycle.ViewModel

class ColoringViewModel: ViewModel(){

    val colorPaletteList = arrayListOf(
        ColorsList(R.string.fire_engine_red, "#000000", 150, "#d62828", false),
        ColorsList(R.string.prussian_blue, "#000000", 175, "#003049", false),
        ColorsList(R.string.xanthous, "#000000", 200, "#fcb322", false),
        ColorsList(R.string.orange, "#000000", 225, "#f77f00", false),
        ColorsList(R.string.vanilla, "#000000", 250, "#eae2b7", false),
        ColorsList(R.string.wine, "#000000", 275,"#6b2c39", false),
        ColorsList(R.string.spanish_orange, "#000000", 285,"#e96e25", false),
        ColorsList(R.string.auburn, "#000000", 300, "#a12a31", false),
        ColorsList(R.string.dark_purple, "#000000", 315, "#6b2c39", false),
        ColorsList(R.string.earth_yellow, "#000000", 330, "#f1b15c", false),
        ColorsList(R.string.eggplant, "#000000", 345, "#512d3d", false),
        ColorsList(R.string.pakistan_green, "#000000", 360, "#004a0c", false),
        ColorsList(R.string.black_bean, "#000000", 370, "#4A0000", false),
        ColorsList(R.string.citrine, "#000000", 380, "#D3C312", false),
        ColorsList(R.string.lime_green, "#000000", 390, "#12D332", false),
        ColorsList(R.string.celestial_blue, "#000000", 400, "#1290D3", false),
        ColorsList(R.string.red_violet, "#000000", 410, "#D31289", false),
        ColorsList(R.string.magneta, "#000000", 420,"#FF0392", false),
        ColorsList(R.string.mint, "#000000", 430, "#20BB85", false),
        ColorsList(R.string.thulian_pink, "#000000", 440, "#DD6DA3", false)
    )

    fun delayColorChange() {
        for(i in colorPaletteList) {
            i.textColor = "#000000"
        }
    }

}