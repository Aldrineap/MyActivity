package com.alarcon.myactivity3

    import android.content.Intent
    import androidx.appcompat.app.AlertDialog
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.widget.Toast
    import com.alarcon.myactivity3.databinding.ActivityRegisterBinding


class StudentRegister : AppCompatActivity() {
        private lateinit var binding: ActivityRegisterBinding
        private val userList = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityRegisterBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // Set an onClickListener for the Register button
        binding.registerButton.setOnClickListener {
            // Get the input values from the EditText fields
            val firstName = binding.firstNameEditText.text.toString()
            val lastName = binding.lastNameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            // Perform validation on the input values
            if (firstName.isBlank() || lastName.isBlank() || email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // Create a new User object with the input values
            val user = User(firstName, lastName, email, password)
            userList.add(user) // Add the user to the list


            // Show a message dialog to notify the user about the successful registration
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Registration Successful")
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                    // Redirect the user to the LoginActivity
                    val intent = Intent(this@StudentRegister, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            val dialog = builder.create()
            dialog.show()
        }
   }
}


