package com.maktab87programs.taskmanager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class TaskViewModel: ViewModel() {

    private val usernameLive = MutableLiveData<String>()
    private val statusLive = MutableLiveData<String>()

    private val todoTaskList = arrayListOf<Task>()
    private val doneTaskList = arrayListOf<Task>()
    private val doingTaskList = arrayListOf<Task>()

    val todoTaskListLive = MutableLiveData<ArrayList<Task>>()
    val doneTaskListLive = MutableLiveData<ArrayList<Task>>()
    val doingTaskListLive = MutableLiveData<ArrayList<Task>>()

    private fun pushTodo(todoList: ArrayList<Task>) {
        todoTaskListLive.postValue(todoList)
    }
    private fun pushDoing(doingList: ArrayList<Task>) {
        doingTaskListLive.postValue(doingList)
    }
    private fun pushDone(doneList: ArrayList<Task>) {
        doneTaskListLive.postValue(doneList)
    }

    fun initData(username: String, status: String) {
        usernameLive.value = username
        statusLive.value = status
    }

    val allTaskList = arrayListOf<Task>()
    val userTask = arrayListOf<Task>()

    fun createTask() {
        allTaskList.add(Task(usernameLive.value!!, "dars", "desc", "date", "time", State.DOING.name))
        pushDoing(allTaskList)
    }

}