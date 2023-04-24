package com.maktab87programs.taskmanager.database

import androidx.room.*
import com.maktab87programs.taskmanager.User

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM usersTable WHERE user_id = :userId")
    suspend fun deleteSelectedUsers(users: List<User>)

    @Query("DELETE * FROM user_table")
    suspend fun deleteAllUsers()
}