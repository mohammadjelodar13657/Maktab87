package com.maktbesharif.hw_13_2.tasklist

enum class State {
    TODO, DOING, DONE
}

enum class TaskName(val taskName: String) {
    StudyMath("Study Math"),
    StudyChemistry("Study Chemistry"),
    StudyDataBase("Study DataBase"),
    StudyDataStructure("Study Data Structure"),
}