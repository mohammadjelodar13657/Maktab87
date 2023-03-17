package com.maktbesharif.homework15

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3
    }

//    override fun createFragment(position: Int): Fragment {
//        val fragment = FirstFragment()
//        fragment.arguments = Bundle().apply {
//            putString(Eshagh.ARG_OBJECT, "Page number ${ position + 1 }")
//        }
//        return fragment
//    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                TodoFragment()
            }
            1 -> {
                DoingFragment()
            }
            2 -> {
                DoneFragment()
            }
            else -> {
                TodoFragment()
            }
        }
    }
}