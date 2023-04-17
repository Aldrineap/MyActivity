package com.alarcon.myactivity3


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.alarcon.myactivity3.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var students: Array<Student>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val students = intent?.extras?.getParcelableArrayList<Student>("students")?.toTypedArray() ?: emptyArray()


        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (isRegistered(email, password)) {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            } else {
                binding.errorMessageTextView.visibility = View.VISIBLE
            }
        }

        binding.forgotPasswordTextView.setOnClickListener {
            val intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }

        binding.registerButtonTextView.setOnClickListener {
            val intent = Intent(this, StudentRegister::class.java)
            startActivity(intent)
        }

        binding.homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun isRegistered(email: String, password: String): Boolean {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val registeredEmail = sharedPreferences.getString("email", null)
        val registeredPassword = sharedPreferences.getString("password", null)
        return registeredEmail == email && registeredPassword == password
    }
}

