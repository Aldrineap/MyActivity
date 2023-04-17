package com.alarcon.myactivity3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alarcon.myactivity3.databinding.ActivityMain2Binding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

               val pagerAdapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 3

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> ListFragment()
                    1 -> SearchFragment()
                    2 -> TransactionFragment()
                    else -> throw IllegalArgumentException("Invalid tab position: $position")
                }
            }
        }
        binding.viewPager.adapter = pagerAdapter

               TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "List"
                1 -> tab.text = "Search"
                2 -> tab.text = "Transaction"
            }
        }.attach()
    }
}
