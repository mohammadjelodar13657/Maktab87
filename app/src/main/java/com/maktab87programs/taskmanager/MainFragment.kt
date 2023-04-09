package com.maktab87programs.taskmanager

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.maktab87programs.taskmanager.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: ViewPagerAdapter
    private var labelsList: ArrayList<String> = arrayListOf("Todo", "Doing", "Done")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        adapter = ViewPagerAdapter(this)
        val viewPager = binding.viewPager
        viewPager.adapter = adapter

        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) {
            tab, position -> tab.text = labelsList[position]
        }.attach()
    }
}