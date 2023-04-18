package com.maktab87programs.taskmanager

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.maktab87programs.taskmanager.databinding.ActivityTaskManagerBinding

class TaskManagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTaskManagerBinding
    private lateinit var navController: NavController
    private val viewModel: TaskManagerViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_task_manager)

        binding.customToolbar.logout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.customToolbar.user.text = "Hi ${intent.getStringExtra(LoginFragment.Key.USER_NAME)}"
        binding.customToolbar.status.text = intent.getStringExtra(LoginFragment.Key.STATUS)
    }
}