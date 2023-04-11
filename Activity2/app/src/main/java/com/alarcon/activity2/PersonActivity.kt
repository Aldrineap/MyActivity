package com.alarcon.activity2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alarcon.activity2.databinding.PersonInfoBinding


class PersonActivity :  AppCompatActivity(){

        private lateinit var binding: PersonInfoBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = DataBindingUtil.setContentView(this, R.layout.activity_person_info)
            binding.submitButton.setOnClickListener { onSubmitButtonClicked() }

        }

        private fun onSubmitButtonClicked() {
            // Access form fields using binding and do something with the data
            val position = binding.positionEditText.text.toString()
            val salary = binding.salaryEditText.text.toString()
            val date = binding.dateEditText.text.toString()
            val lastName = binding.lastNameEditText.text.toString()
            val firstName = binding.firstNameEditText.text.toString()
            val middleName = binding.middleNameEditText.text.toString()
            val address = binding.addressEditText.text.toString()
            val city = binding.cityEditText.text.toString()
            val state = binding.stateEditText.text.toString()

            // Do something with the data, like displaying a toast
            val message = "Submitted form data:\nPosition: $position\nSalary: $salary\nDate: $date\nLast Name: $lastName\nFirst Name: $firstName\nMiddle Name: $middleName\nAddress: $address\nCity: $city\nState: $state"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }

    }

