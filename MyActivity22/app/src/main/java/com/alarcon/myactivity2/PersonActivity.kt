package com.alarcon.myactivity2



import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alarcon.myactivity2.databinding.ActivityPersonInfoBinding

class PersonActivity : AppCompatActivity() {

        private lateinit var binding: ActivityPersonInfoBinding

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                binding = ActivityPersonInfoBinding.inflate(layoutInflater)
                setContentView(binding.root)

                binding.nextButton.setOnClickListener {
                        val position = binding.positionEditText.text.toString().trim()
                        val salary = binding.salaryEditText.text.toString().toDoubleOrNull() ?: 0.0
                        val date = binding.dateEditText.text.toString().trim()
                        val lastName = binding.lastNameEditText.text.toString().trim()
                        val firstName = binding.firstNameEditText.text.toString().trim()
                        val middleName = binding.middleNameEditText.text.toString().trim()
                        val address = binding.addressEditText.text.toString().trim()
                        val city = binding.cityEditText.text.toString().trim()

                        val validInput = validateInput(position, salary, date, lastName, firstName, middleName, address, city)

                        if (validInput) {
                                val intent = Intent(this, PersonActivityPage2::class.java)
                                intent.putExtra("position", position)
                                intent.putExtra("salary", salary)
                                intent.putExtra("date", date)
                                intent.putExtra("lastName", lastName)
                                intent.putExtra("firstName", firstName)
                                intent.putExtra("middleName", middleName)
                                intent.putExtra("address", address)
                                intent.putExtra("city", city)
                                startActivity(intent)
                        } else {
                                Toast.makeText(this, "Please enter valid information", Toast.LENGTH_SHORT).show()
                        }
                }
        }

        private fun validateInput(position: String, salary: Double, date: String, lastName: String, firstName: String, middleName: String, address: String, city: String): Boolean {
                return position.isNotBlank() && salary > 0 && date.isNotBlank() && lastName.isNotBlank() && firstName.isNotBlank() && address.isNotBlank() && city.isNotBlank()
        }
}
