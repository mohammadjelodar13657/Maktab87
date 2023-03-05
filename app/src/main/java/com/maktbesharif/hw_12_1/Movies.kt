package com.maktbesharif.hw_12_1

data class Movies(
    private var names: Int,
    private var pics: Int,
    private var favIcon: Int,
    private var isClicked: Boolean = false,
    private var isClickable: Boolean = false
)
