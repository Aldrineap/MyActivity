package com.alarcon.myactivity5

    import androidx.fragment.app.Fragment
    import androidx.fragment.app.FragmentActivity
    import androidx.viewpager2.adapter.FragmentStateAdapter

    class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
//                0 -> ListFragment()
//                1 -> SearchFragment()
//                2 -> TransactionFragment()
                else -> throw IllegalStateException("Invalid position $position")
            }
        }
    }
