package com.maktbesharif.azmoonqueez.task

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel: ViewModel() {

    lateinit var status : TaskStatus

    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val date = MutableLiveData<String>()

    fun toDoStatus() {
        status = TaskStatus.TODO
    }

    fun doingStatus() {
        status = TaskStatus.DOING
    }

    fun doneStatus() {
        status = TaskStatus.DONE
    }

    val toDoList = mutableListOf<Task>()
    val doingList = mutableListOf<Task>()
    val doneList = mutableListOf<Task>()

    fun checkStatus(): String {
        return if(title.value?.isNotEmpty()!! && description.value?.isNotEmpty()!! && date.value?.isNotEmpty()!!) {
            when (status) {
                TaskStatus.TODO -> {
                    toDoList.add(Task("study", "Geography", "25 september"))
                }
                TaskStatus.DONE -> {
                    doneList.add(Task("study", "Math", "24 december"))
                }
                TaskStatus.DOING -> {
                    doingList.add(Task("study", "Chemistry", " 15 October"))
                }
            }
            "Task Created"
        }
        else "Enter Data"
    }

}