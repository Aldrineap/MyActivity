package com.alarcon.myfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alarcon.myactivty5.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class activity_main : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewPager()
    }

    private fun setupViewPager() {
        val viewPager = binding.viewPager
        viewPager.adapter = ViewPagerAdapter(this)

        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "List"
                1 -> "Search"
                2 -> "Transaction"
                else -> throw IllegalStateException("Invalid position $position")
            }
        }.attach()
    }
}
