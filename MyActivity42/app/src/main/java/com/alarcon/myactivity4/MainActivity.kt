package com.alarcon.myactivity4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.alarcon.myactivity4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.historyButton.setOnClickListener {
            val intent = Intent(this, HistoryQuestionActivity::class.java)
            startActivity(intent)
        }

        binding.geographyButton.setOnClickListener {
            val intent = Intent(this, GeographyQuestionActivity::class.java)
            startActivity(intent)
        }

        binding.scienceButton.setOnClickListener {
            val intent = Intent(this, ScienceQuestionActivity::class.java)
            startActivity(intent)
        }

        binding.forexButton.setOnClickListener {
            val intent = Intent(this, ForexQuestionActivity::class.java)
            startActivity(intent)
        }
    }
}

