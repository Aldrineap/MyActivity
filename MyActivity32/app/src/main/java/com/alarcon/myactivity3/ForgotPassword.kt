package com.alarcon.myactivity3

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.alarcon.myactivity3.databinding.ActivityPasswordBinding
import com.alarcon.myactivity3.MainActivity

class ForgotPassword : AppCompatActivity() {

    private lateinit var binding: ActivityPasswordBinding
    private lateinit var email: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // get email and password from previous activity
        email = intent.getStringExtra("email") ?: ""
        Log.d("ForgotPassword", "Email: $email")
        password = intent.getStringExtra("password") ?: ""

        binding.forgotButton.setOnClickListener {
            val inputEmail = binding.forgotView.text.toString().trim()
            when {
                inputEmail.isEmpty() -> {
                    binding.forgotView.error = "Email cannot be empty"
                }
                !Patterns.EMAIL_ADDRESS.matcher(inputEmail).matches() -> {
                    binding.forgotView.error = "Invalid email address"
                }
                !MainActivity.Companion.emailExists(inputEmail, applicationContext) -> {
                    binding.forgotView.error = "Email does not match"
                }
                else -> {
                    // send password reset email to user
                    sendPasswordResetEmail(inputEmail)

                    // show success message
                    val message = getString(R.string.password_send_to_email, inputEmail)
                    binding.passwordTextView.text = message

                    Handler(Looper.getMainLooper()).postDelayed({
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }, 3000)
                }
            }
        }
    }

    private fun sendPasswordResetEmail(email: String) {
        val message = getString(R.string.password_display_message, password)
        binding.passwordTextView.text = message.replace("<password>", password)
    }
}
