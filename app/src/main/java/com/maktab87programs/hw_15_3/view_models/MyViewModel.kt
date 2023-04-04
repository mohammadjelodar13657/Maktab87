package com.maktab87programs.hw_15_3.view_models

import androidx.lifecycle.ViewModel
import com.maktab87programs.hw_15_3.data_models.DataModel

class MyViewModel: ViewModel() {

    val imageUrl1 = DataModel(
        "https://fastly.picsum.photos/id/866/200/300.jpg?hmac=rcadCENKh4rD6MAp6V_ma-AyWv641M4iiOpe1RyFHeI"
    )

    val imageUrl2 = DataModel(
        "https://fastly.picsum.photos/id/134/200/300.jpg?hmac=KN18cCDft4FPM0XJpr7EhZLtUP6Z4cZqtF8KThtTvsI"
    )

    val imageUrl3 = DataModel(
        "https://fastly.picsum.photos/id/234/200/300.jpg?hmac=KD9xFDCez7-lqgcMm-EEi7BtpClIdCzJS6YvFVyLiDs"
    )

    val imageUrl4 = DataModel(
        "https://fastly.picsum.photos/id/757/200/300.jpg?hmac=su32mJgKVc94YgSiaPE3SzaIM11AtqJgoGffpSTQUOE"
    )


}