package com.alarcon.myactivity3

import android.content.Intent
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.alarcon.myactivity3.databinding.ActivityRegisterBinding

class StudentRegister : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

                binding.registerButton.setOnClickListener {

            val firstName = binding.firstNameEditText.text.toString()
            val lastName = binding.lastNameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()


            if (firstName.isBlank() || lastName.isBlank() || email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(applicationContext)
            sharedPreferences.edit()
                .putString("firstName", firstName)
                .putString("lastName", lastName)
                .putString("email", email)
                .putString("password", password)
                .apply()


            val builder = AlertDialog.Builder(this)
            builder.setMessage("Registration Successful")
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()

                    val intent = Intent(this@StudentRegister, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            val dialog = builder.create()
            dialog.show()
        }
    }
}