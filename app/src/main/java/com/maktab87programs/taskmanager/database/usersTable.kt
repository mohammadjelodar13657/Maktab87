package com.maktab87programs.taskmanager.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class usersTable (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    val userId: Long = 0L,

    @ColumnInfo(name = "user_first_name")
    val firstName: String,

    @ColumnInfo(name = "user_last_name")
    val lastName: String,

    @ColumnInfo(name = "user_username")
    val userName: String,

    @ColumnInfo(name = "user_email")
    val email: String,

    @ColumnInfo(name = "user_password")
    val password: String
        )