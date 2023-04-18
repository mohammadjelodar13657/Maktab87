package com.maktab87programs.taskmanager

import com.maktab87programs.taskmanager.data.TaskService

class TaskRepository(private val taskService: TaskService) {

    fun getAllTasks(): ArrayList<Task> {
        return taskService.getAllTasks()
    }

    fun addTask(task: Task) {
        taskService.addTask(task)
    }

    fun updateTask(task: Task){
        taskService.updateTask(task)
    }

    fun deleteTask(task: Task) {
        taskService.deleteTask(task)
    }

    fun deleteSelectedTasks(tasks: ArrayList<Task>) {
        taskService.deleteSelectedTasks(tasks)
    }

    fun deleteAllTasks() {
        taskService.getAllTasks()
    }
}