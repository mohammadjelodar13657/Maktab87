package com.maktab87programs.taskmanager.data

import com.maktab87programs.taskmanager.Task

interface TaskService {

    fun getAllTasks(): ArrayList<Task>
    fun addTask(task: Task)
    fun updateTask(task: Task)
    fun deleteTask(task: Task)
    fun deleteSelectedTasks(tasks: ArrayList<Task>)
    fun deleteAllTasks()

}