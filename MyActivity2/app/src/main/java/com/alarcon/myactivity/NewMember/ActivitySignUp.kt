package com.alarcon.myactivity.NewMember

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alarcon.myactivity.databinding.SignUpBinding

class ActivitySignUp : AppCompatActivity() {

    private lateinit var binding: SignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.welcomeText.text = "Welcome to"
        binding.firestoreText.text = "Firestore"
        binding.firestoreText.textSize = 45f
        binding.createAccountText.text = "Let's create an account to save your file"
        binding.facebookButton.text = "Continue with Facebook"
        binding.facebookButton.setOnClickListener {
        }
        binding.googleButton.text = "Continue with Google"
        binding.googleButton.setOnClickListener {
        }
        binding.signUpButton.text = "Sign Up"
        binding.signUpButton.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }

    }
}
