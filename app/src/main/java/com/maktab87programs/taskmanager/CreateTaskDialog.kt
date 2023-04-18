package com.maktab87programs.taskmanager

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.maktab87programs.taskmanager.databinding.CustomDialogLayoutBinding
import java.util.*

class CreateTaskDialog : DialogFragment() {

    val sharedViewModel by activityViewModels<TaskManagerViewModel>()

    private lateinit var binding: CustomDialogLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CustomDialogLayoutBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = sharedViewModel
        binding.lifecycleOwner = this

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hour = calendar.get(Calendar.HOUR)
        val minute = calendar.get(Calendar.MINUTE)
        var date = "$year-$month-$day"
        var time = "$hour:$minute"

        binding.saveBtn.setOnClickListener {
            when {
                binding.todoRb.isChecked -> sharedViewModel.todo.value = true
                binding.doingRb.isChecked -> sharedViewModel.doing.value = true
                binding.doneRb.isChecked -> sharedViewModel.done.value = true
            }
            sharedViewModel.saveTask()
            dismiss()
        }

        binding.datePickerEditText.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { _, year, monthOfYear, dayOfMonth ->
                    date =
                        (year.toString() + "-" + (monthOfYear + 1) + "-" + dayOfMonth)

                },
                year, month, day
            )
            datePickerDialog.show()
            sharedViewModel.date.value = date
            binding.datePickerEditText.setText(date)
        }

        binding.timePickerEditText.setOnClickListener {
            TimePickerDialog(
                requireContext(), { _, hours, minute ->
                    time = "$hours:$minute"
                },
                hour, minute, false
            ).show()
            sharedViewModel.time.value = time
            binding.timePickerEditText.setText(time)
        }
    }
}