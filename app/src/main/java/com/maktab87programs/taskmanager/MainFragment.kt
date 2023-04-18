package com.maktab87programs.taskmanager

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.maktab87programs.taskmanager.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: ViewPagerAdapter
    private var labelsList: ArrayList<String> = arrayListOf("Todo", "Doing", "Done")
    private val sharedViewModel by activityViewModels<TaskManagerViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        if (!activity?.intent?.getStringExtra(LoginFragment.Key.USER_NAME).isNullOrEmpty() &&
            !activity?.intent?.getStringExtra(LoginFragment.Key.STATUS).isNullOrEmpty()
        ) {
            sharedViewModel.initData(
                activity?.intent?.getStringExtra(LoginFragment.Key.USER_NAME)!!,
                activity?.intent?.getStringExtra(LoginFragment.Key.STATUS)!!
            )
        }

        adapter = ViewPagerAdapter(this)
        val viewPager = binding.viewPager
        viewPager.adapter = adapter

        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = labelsList[position]
        }.attach()

        binding.createTaskBtn.setOnClickListener {
            val createTaskDialog = CreateTaskDialog()
            createTaskDialog.show(parentFragmentManager, "createTaskDialog")
        }
    }
}