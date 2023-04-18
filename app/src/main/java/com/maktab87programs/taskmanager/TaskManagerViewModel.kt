package com.maktab87programs.taskmanager

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskManagerViewModel(private val taskRepository: TaskRepository): ViewModel() {

    // Set username and user status in action bar
    private val usernameLive = MutableLiveData<String>()
    private val userStatus = MutableLiveData<String>()

    // list of tasks
    var totalTodoList = arrayListOf<Task>()
    var totalDoingList = arrayListOf<Task>()
    var totalDoneList = arrayListOf<Task>()
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

    // live data for creating tasks
    var taskTitle = MutableLiveData<String>()
    var taskDescription = MutableLiveData<String>()
    var todo = MutableLiveData<Boolean>()
    var doing = MutableLiveData<Boolean>()
    var done = MutableLiveData<Boolean>()
    var date = MutableLiveData<String>()
    var time = MutableLiveData<String>()

    init {
        todo.value = false
        doing.value = false
        done.value = false
    }

    // create and save tasks
    fun saveTask() {
        val userName = usernameLive.value ?: ""
        val title = taskTitle.value ?: ""
        val description = taskDescription.value ?: ""
        val date = date.value ?: ""
        val time = time.value ?: ""
        val status = when {
            todo.value == true -> State.TODO.name
            doing.value == true -> State.DOING.name
            else -> State.DONE.name
        }

        val task = Task(userName, title, description, date, time, status)
        when(status) {
            State.TODO.name -> {
                totalTodoList.add(task)
                pushTodo(totalTodoList)
            }
            State.DOING.name -> {
                totalDoingList.add(task)
                pushDoing(totalDoingList)
            }
            State.DONE.name -> {
                totalDoneList.add(task)
                pushDone(totalDoneList)
            }
        }

        Log.e("todo", "saveTask: ${totalTodoList}", )
        Log.e("doing", "saveTask: ${totalDoingList}", )
        Log.e("done", "saveTask: ${totalDoneList}", )

        clearFields()
    }

    // on cancel click
    fun cancel() {
        clearFields()
    }

    // clear fields
    private fun clearFields() {
        taskTitle.value = ""
        taskDescription.value = ""
        todo.value = false
        doing.value = false
        done.value = false
    }

    // get username and status from login page
    fun initData(username: String, status: String) {
        usernameLive.value = username
        userStatus.value = status
    }

    fun getAllTasks() {
        val allTasksList = taskRepository.getAllTasks()
        for(task in allTasksList) {
            when(task.state) {
                State.TODO.name -> {
                    totalTodoList.add(task)
                    pushTodo(totalTodoList)
                }
                State.DOING.name -> {
                    totalDoingList.add(task)
                    pushDoing(totalDoingList)
                }
                State.TODO.name -> {
                    totalDoneList.add(task)
                    pushDone(totalDoneList)
                }
            }
        }
    }
}