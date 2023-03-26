package com.maktbesharif.hw_15_1

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.maktbesharif.hw_15_1.tabbedfragments.DoingFragment
import com.maktbesharif.hw_15_1.tabbedfragments.DoneFragment
import com.maktbesharif.hw_15_1.tabbedfragments.TodoFragment

class ViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> TodoFragment()
            1 -> DoingFragment()
            2 -> DoneFragment()
            else -> TodoFragment()
        }
    }
}