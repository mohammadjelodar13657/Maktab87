package com.maktab87programs.taskmanager.data

import com.maktab87programs.taskmanager.Task

class TaskDataBase: TaskService {
    override fun getAllTasks(): ArrayList<Task> {
        return TaskTable.taskList
    }

    override fun addTask(task: Task) {
        task.id = TaskTable.id
        TaskTable.taskList.add(task)
        TaskTable.id++
    }

    override fun updateTask(task: Task) {
        for(i in TaskTable.taskList.indices) {
            if(TaskTable.taskList[i].id == task.id) {
                TaskTable.taskList[i] == task
            }
        }
    }

    override fun deleteTask(task: Task) {
        TaskTable.taskList.remove(task)
    }

    override fun deleteSelectedTasks(tasks: ArrayList<Task>) {
        for(task in tasks) {
            TaskTable.taskList.remove(task)
        }
    }

    override fun deleteAllTasks() {
        TaskTable.taskList.clear()
    }
}