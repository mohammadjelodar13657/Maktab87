package com.maktbesharif.homework15

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.maktbesharif.homework15.databinding.FragmentMainBinding
import com.maktbesharif.hw_13_2.tasklist.Task
import com.maktbesharif.hw_13_2.tasklist.TaskListViewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    lateinit var adapter: ViewPagerAdapter
    private val labelList: ArrayList<String> = arrayListOf("Todo", "Doing", "Done")
    private lateinit var binding: FragmentMainBinding
    val sharedViewModel by activityViewModels<TaskListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        binding.floatingButton.setOnClickListener {
            sharedViewModel.taskList.add(Task(sharedViewModel.defineTaskName().taskName, sharedViewModel.defineState()))
            sharedViewModel.setList(sharedViewModel.taskList)
        }

        adapter = ViewPagerAdapter(this)
        val viewPager2 = view.findViewById<ViewPager2>(R.id.viewPager2)
        viewPager2.adapter = adapter

        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager2) {
                tab, position -> tab.text = labelList[position]
        }.attach()
    }
}