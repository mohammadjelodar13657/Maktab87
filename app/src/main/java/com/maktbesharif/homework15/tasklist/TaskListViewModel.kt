package com.maktbesharif.hw_13_2.tasklist

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskListViewModel: ViewModel() {

    val todoTaskList = arrayListOf<Task>()
    val doneTaskList = arrayListOf<Task>()
    val doingTaskList = arrayListOf<Task>()

    val todoTaskListLive = MutableLiveData<ArrayList<Task>>()
    val doneTaskListLive = MutableLiveData<ArrayList<Task>>()
    val doingTaskListLive = MutableLiveData<ArrayList<Task>>()

    fun pushTodo(todoList: ArrayList<Task>) {
        todoTaskListLive.postValue(todoList)
    }
    fun pushDoing(doingList: ArrayList<Task>) {
        doingTaskListLive.postValue(doingList)
    }
    fun pushDone(doneList: ArrayList<Task>) {
        doneTaskListLive.postValue(doneList)
    }

    fun createTask() {
        when(defineState()) {
            State.TODO -> {
                todoTaskList.add(Task(defineTaskName().taskName, State.TODO))
                pushTodo(todoTaskList)
                Log.e(TAG, "todo: ${todoTaskList}", )
            }
            State.DOING -> {
                doingTaskList.add(Task(defineTaskName().taskName, State.DOING))
                pushDoing(doingTaskList)
                Log.e(TAG, "done: ${doingTaskList}", )
            }
            State.DONE -> {
                doneTaskList.add(Task(defineTaskName().taskName, State.DONE))
                pushDone(doneTaskList)
                Log.e(TAG, "doing: ${doneTaskList}", )
            }
        }
    }

    fun defineState(): State {
        return State.values().random()
    }

    fun defineTaskName(): TaskName {
        return TaskName.values().random()
    }
}