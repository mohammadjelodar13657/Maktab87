package com.maktab87programs.taskmanager

data class Task(
    var id: Long = 0L,
    val userName: String,
    val title: String,
    val description: String,
    val date: String,
    val time: String,
    val state: String
)
