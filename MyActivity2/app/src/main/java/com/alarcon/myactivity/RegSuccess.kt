package com.alarcon.myactivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alarcon.myactivity.databinding.ActivityRegSuccessBinding

class RegSuccess : AppCompatActivity() {

    private lateinit var binding: ActivityRegSuccessBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.getStringExtra("email")

        // Set text for email message

        binding.checkInboxText.text = "$email ${getString(R.string.check_inbox_message)} "
        binding.thatMessage.text = getString(R.string.that_message_text)

        // Set click listener for log in text view
        binding.loginTextview.setOnClickListener {
            // Launch the login activity
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
            finish() // finish the current activity to prevent going back to it
        }
    }
}
