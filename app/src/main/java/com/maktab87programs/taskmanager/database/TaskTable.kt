package com.maktab87programs.taskmanager.database

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class TasksTable(

    @ColumnInfo(name = "task_id")
    val taskId: Long = 0L,

    @ColumnInfo(name = "task_title")
    val taskTitle: String,

    @ColumnInfo(name = "task_description")
    val taskDescription: String,

    @ColumnInfo(name = "task_date")
    val taskDate: String,

    @ColumnInfo(name = "task_time")
    val taskTime: String,

    @ColumnInfo(name = "task_state")
    val taskState: String

)