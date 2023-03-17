package com.maktbesharif.hw_13_2.tasklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskListViewModel: ViewModel() {

    val todoTaskList = arrayListOf<Task>()
    val doneTaskList = arrayListOf<Task>()
    val doingTaskList = arrayListOf<Task>()

    val taskLive = MutableLiveData<ArrayList<Task>>()

    val taskList = arrayListOf<Task>()

    fun setList(list: ArrayList<Task>) {
        taskLive.postValue(list)
    }

//    init {
//        setList(taskList)
//    }

    fun createTask() {
        when(defineState()) {
            State.TODO -> taskList.add(Task(defineTaskName().taskName, defineState()))
            State.DOING -> taskList.add(Task(defineTaskName().taskName, defineState()))
            State.DONE -> taskList.add(Task(defineTaskName().taskName, defineState()))
        }
    }

    fun defineState(): State {
        return State.values().random()
    }

    fun defineTaskName(): TaskName {
        return TaskName.values().random()
    }
}