package com.alarcon.myactivity2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alarcon.myactivity2.databinding.ActivityPersonInfo2Binding

class PersonActivityPage2 : AppCompatActivity() {

    private var binding: ActivityPersonInfo2Binding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonInfo2Binding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.usYesCheckBox.setOnClickListener(View.OnClickListener {
            if (binding!!.usYesCheckBox.isChecked) {
                binding!!.usNoCheckBox.isChecked = false
            }
        })

        binding!!.usNoCheckBox.setOnClickListener(View.OnClickListener {
            if (binding!!.usNoCheckBox.isChecked) {
                binding!!.usYesCheckBox.isChecked = false
            }
        })

        binding!!.felonyYesCheckBox.setOnClickListener(View.OnClickListener {
            if (binding!!.felonyYesCheckBox.isChecked) {
                binding!!.felonyNoCheckBox.isChecked = false
            }
        })

        binding!!.felonyNoCheckBox.setOnClickListener(View.OnClickListener {
            if (binding!!.felonyNoCheckBox.isChecked) {
                binding!!.felonyYesCheckBox.isChecked = false
            }
        })

        binding!!.selectYesCheckBox.setOnClickListener(View.OnClickListener {
            if (binding!!.selectYesCheckBox.isChecked) {
                binding!!.selectNoCheckBox.isChecked = false
            }
        })

        binding!!.selectNoCheckBox.setOnClickListener(View.OnClickListener {
            if (binding!!.selectNoCheckBox.isChecked) {
                binding!!.selectYesCheckBox.isChecked = false
            }
        })

        binding!!.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun savePerson(view: View?) {
        val homePhone: String = binding?.homePhoneEditText?.text.toString().trim()
        val cellularPhone: String = binding?.cellularPhoneEditText?.text.toString().trim()
        val socialSecurity: String = binding?.socialSecurityEditText?.text.toString().trim()

        if (homePhone.isEmpty() || cellularPhone.isEmpty() || socialSecurity.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
            return
        }

        val usCitizen: String = if (binding?.usYesCheckBox?.isChecked == true) {
            "Yes"
        } else if (binding?.usNoCheckBox?.isChecked == true) {
            "No"
        } else {
            Toast.makeText(
                this,
                "Please select whether or not you are a US citizen.",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (binding!!.felonyYesCheckBox.isChecked) {
            "Yes"
        } else if (binding!!.felonyNoCheckBox.isChecked) {
            "No"
        } else {
            ""
        }
    }
}
