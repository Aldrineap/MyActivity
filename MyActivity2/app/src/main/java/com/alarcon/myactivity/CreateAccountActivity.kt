package com.alarcon.myactivity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.util.Log
import com.alarcon.myactivity.databinding.ActivityCreateAccountBinding
import java.security.MessageDigest

class CreateAccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAccountBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("CreateAccountActivity", "onCreate called")
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)

        binding.passwordEditText.transformationMethod = PasswordTransformationMethod.getInstance() // Mask the password with dots

        binding.signUpButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val editor = sharedPreferences.edit()
            editor.putString("name_$email", name)
            editor.putString("email_$email", email)
            editor.putString("password_$email", hashPassword(password))
            editor.apply()
            startActivity(Intent(this,LogInActivity::class.java))
        }

        binding.passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // No need to mask the password again as PasswordTransformationMethod will do it
            }
        })
    }

    private fun hashPassword(password: String): String {
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(password.toByteArray())
        return digest.fold("", { str, it -> str + "%02x".format(it) })
    }
}
