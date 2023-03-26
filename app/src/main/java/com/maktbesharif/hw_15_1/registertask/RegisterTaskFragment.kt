package com.maktbesharif.hw_15_1.registertask

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.maktbesharif.hw_15_1.R
import com.maktbesharif.hw_15_1.databinding.FragmentRegisterTaskBinding
import com.maktbesharif.hw_15_1.viewtask.ViewTaskActivity

class RegisterTaskFragment : Fragment(R.layout.fragment_register_task) {

    companion object {
        const val KEY_NAME = "KEY_NAME"
        const val KEY_NUMBER = "KEY_NUMBER"
    }

    private val registerTaskViewModel: RegisterTaskViewModel by viewModels()
    private lateinit var binding: FragmentRegisterTaskBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.viewModel = registerTaskViewModel

        binding.create.setOnClickListener {
            registerTaskViewModel.check()
            if (!registerTaskViewModel.status) {
                registerTaskViewModel.checkFields.observe(viewLifecycleOwner) {
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                }
            } else {
                val intent = Intent(activity, ViewTaskActivity::class.java)
                with(intent) {
                    putExtra(KEY_NAME, registerTaskViewModel.name.value)
                    putExtra(KEY_NUMBER, registerTaskViewModel.numberOfTasks.value)
                }
                startActivity(intent)
            }
        }

    }
}