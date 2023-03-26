package com.maktbesharif.hw_15_1.viewtask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maktbesharif.hw_15_1.State
import com.maktbesharif.hw_15_1.Task

class TaskListViewModel: ViewModel() {

    private val _taskName = MutableLiveData("")
    private val taskName: LiveData<String?> = _taskName

    private val _taskNumber = MutableLiveData(0)
    private val taskNumber: LiveData<Int?> = _taskNumber

    private val todoTaskList = arrayListOf<Task>()
    private val doneTaskList = arrayListOf<Task>()
    private val doingTaskList = arrayListOf<Task>()

    val todoTaskListLive = MutableLiveData<ArrayList<Task>>()
    val doneTaskListLive = MutableLiveData<ArrayList<Task>>()
    val doingTaskListLive = MutableLiveData<ArrayList<Task>>()

    fun initData(name: String, number: Int) {
        _taskName.value = name
        _taskNumber.value = number
    }

    fun createTaskList() {
        for(i in 0 until taskNumber.value!!) {
            createTask()
        }
    }

    private fun pushTodo(todoList: ArrayList<Task>) {
        todoTaskListLive.postValue(todoList)
    }
    private fun pushDoing(doingList: ArrayList<Task>) {
        doingTaskListLive.postValue(doingList)
    }
    private fun pushDone(doneList: ArrayList<Task>) {
        doneTaskListLive.postValue(doneList)
    }

    fun createTask() {
        when(defineState()) {
            State.TODO -> {
                todoTaskList.add(Task(taskName.value, State.TODO))
                pushTodo(todoTaskList)
            }
            State.DOING -> {
                doingTaskList.add(Task(taskName.value, State.DOING))
                pushDoing(doingTaskList)
            }
            State.DONE -> {
                doneTaskList.add(Task(taskName.value, State.DONE))
                pushDone(doneTaskList)
            }
        }
    }

    private fun defineState(): State {
        return State.values().random()
    }
}