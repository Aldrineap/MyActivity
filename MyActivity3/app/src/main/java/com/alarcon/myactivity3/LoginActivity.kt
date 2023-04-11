package com.alarcon.myactivity3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alarcon.myactivity3.databinding.ActivityLoginBinding
import com.alarcon.myactivity3.databinding.WelcomeBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var welcomeBinding: WelcomeBinding
    private val userList = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize the binding object for activity_login.xml
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        // Initialize the binding object for welcome.xml
        welcomeBinding = DataBindingUtil.setContentView(this, R.layout.welcome)

        // Set a click listener for the login button
        binding.loginButton.setOnClickListener {
            // Get the input values from the EditText fields
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            // Check if the user is registered
            val user = userList.find { it.email == email }
            if (user == null) {
                // User is not registered, go to create_member
                val intent = Intent(this, StudentRegister::class.java)
                startActivity(intent)
            } else {
                // User is registered, check the password
                if (user.password == password) {
                    // Password matches, go to login_member
                    val intent = Intent(this, LoginMember::class.java)
                    startActivity(intent)
                } else {
                    // Password does not match
                    welcomeBinding.welcomeMessage.text = "Incorrect password"
                    setContentView(welcomeBinding.root)
                }
            }
        }

        // Set a click listener for the forgot password button
        binding.forgotPasswordButton.setOnClickListener {
            // Perform forgot password action
        }

        // Set a click listener for the home button
        binding.home.setOnClickListener {
            // Navigate back to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
