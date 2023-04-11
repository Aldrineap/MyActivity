package com.alarcon.activity2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_main)

        val personalInfoButton = findViewById<Button>(R.id.personalInfoButton)
        val educationButton = findViewById<Button>(R.id.educationButton)
        val employmentButton = findViewById<Button>(R.id.employmentButton)
        val referencesButton = findViewById<Button>(R.id.referencesButton)
        val acknowledgmentButton = findViewById<Button>(R.id.acknowledgmentButton)

        personalInfoButton.setOnClickListener {
            val intent = Intent(this, PersonActivity::class.java)
            startActivity(intent)
        }


        educationButton.setOnClickListener {
//            val intent = Intent(this, EducationActivity::class.java)
//            startActivity(intent)
        }


        employmentButton.setOnClickListener {
//            val intent = Intent(this, EmploymentActivity::class.java)
//            startActivity(intent)
        }


        referencesButton.setOnClickListener {
//            val intent = Intent(this, ReferencesActivity::class.java)
//            startActivity(intent)
        }


        acknowledgmentButton.setOnClickListener {
//            val intent = Intent(this, AcknowledgmentActivity::class.java)
//            startActivity(intent)
        }

    }
}
