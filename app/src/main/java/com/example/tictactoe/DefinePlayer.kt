package com.example.tictactoe

class DefinePlayer {

    private fun throwCoin() = (CoinStatus.Lion.status..CoinStatus.Tale.status).random()

    fun definePlayer() = if(throwCoin() == CoinStatus.Lion.status) "${Players.Player1}"
                                            else "${Players.Player2}"

}