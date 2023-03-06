package com.maktbesharif.hw_12_1

data class Movies(
    var names: Int,
    var pics: Int,
    var favIcon: Int = R.drawable.favorite_border_icon,
    var isClicked: Boolean = false,
    var isClickable: Boolean = false
)
