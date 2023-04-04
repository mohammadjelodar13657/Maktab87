package com.maktbesharif.hw_15_1.viewtask

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.maktbesharif.hw_15_1.R
import com.maktbesharif.hw_15_1.ViewPagerAdapter
import com.maktbesharif.hw_15_1.databinding.FragmentMainBinding
import com.maktbesharif.hw_15_1.registertask.RegisterTaskFragment

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var adapter: ViewPagerAdapter
    private lateinit var binding: FragmentMainBinding
    private val sharedViewModel by activityViewModels<TaskListViewModel>()
    private val labelList: ArrayList<String> = arrayListOf("Todo", "Doing", "Done")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!


        if(!activity?.intent?.getStringExtra(RegisterTaskFragment.KEY_NAME).isNullOrEmpty() &&
            !activity?.intent?.getStringExtra(RegisterTaskFragment.KEY_NUMBER).isNullOrEmpty()
        ) {
            sharedViewModel.initData(
                activity?.intent?.getStringExtra(RegisterTaskFragment.KEY_NAME)!!,
                activity?.intent?.getStringExtra(RegisterTaskFragment.KEY_NUMBER)?.toInt()!!
            )
        }

        sharedViewModel.createTaskList()

        binding.floatingButton.setOnClickListener {
            sharedViewModel.createTask()
        }

//        adapter = ViewPagerAdapter(this)
//        val viewPager = binding.viewPager
//        viewPager.adapter = adapter
//
//        val tabLayout = binding.tabLayout
//        TabLayoutMediator(tabLayout, viewPager) {
//            tab, position -> tab.text = labelList[position]
//        }.attach()
    }
}