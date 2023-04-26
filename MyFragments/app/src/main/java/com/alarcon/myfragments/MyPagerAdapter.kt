package com.alarcon.myfragments

import SearchFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
             0 -> ListFragment()
             1 -> SearchFragment()
//             2 -> TransactionFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}
