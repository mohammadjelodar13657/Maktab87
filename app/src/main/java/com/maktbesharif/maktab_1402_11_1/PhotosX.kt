package com.maktbesharif.maktab_1402_11_1

data class PhotosX(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val photo: List<Photo>,
    val total: Int
)
