package com.alarcon.myactivity2


    import android.os.Bundle
    import androidx.appcompat.app.AppCompatActivity
    import com.alarcon.myactivity2.databinding.ActivityEducationalInfoBinding
    import com.google.android.material.snackbar.Snackbar

class EducationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEducationalInfoBinding
    private val educationList = mutableListOf<Education>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up data binding
        binding = ActivityEducationalInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Set up click listener for the "Another" button
        binding.another.setOnClickListener {
            addAnother()
        }

        // Set up click listener for the "Back" button
        binding.bckButton.setOnClickListener {
            goBack()
        }
    }

    // Function to add another educational information
    private fun addAnother() {
        // Validate input fields
        if (binding.schoolEditText.text.isNullOrEmpty() ||
            binding.locationEditText.text.isNullOrEmpty() ||
            binding.yearAttendEditText.text.isNullOrEmpty() ||
            binding.degreeEditText.text.isNullOrEmpty() ||
            binding.majorEditText.text.isNullOrEmpty()) {

            // Show error message using Snackbar
            Snackbar.make(binding.root, "Please fill all fields", Snackbar.LENGTH_SHORT).show()

        } else {
            // Create new Education object
            val education = Education(
                binding.schoolEditText.text.toString(),
                binding.locationEditText.text.toString(),
                binding.yearAttendEditText.text.toString(),
                binding.degreeEditText.text.toString(),
                binding.majorEditText.text.toString()
            )

            // Add the education object to the list
            educationList.add(education)

            // Clear the input fields
            binding.schoolEditText.text!!.clear()
            binding.locationEditText.text!!.clear()
            binding.yearAttendEditText.text!!.clear()
            binding.degreeEditText.text!!.clear()
            binding.majorEditText.text!!.clear()

            // Show success message using Snackbar
            Snackbar.make(binding.root, "Education added", Snackbar.LENGTH_SHORT).show()
        }
    }

    // Function to go back to MainActivity
    private fun goBack() {
        // Finish current activity and go back to MainActivity
        finish()
    }
}
