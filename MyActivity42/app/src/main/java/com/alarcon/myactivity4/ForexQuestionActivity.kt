package com.alarcon.myactivity4

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alarcon.myactivity4.databinding.ActivityQuestionAnswerBinding

class ForexQuestionActivity : AppCompatActivity() {
    private var currentQuestionIndex = 0
    private var score = 0
    private lateinit var questions: Array<Question>
    private lateinit var binding: ActivityQuestionAnswerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityQuestionAnswerBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        // Set up the questions
        questions = arrayOf(
            Question("What is the currency used in the Philippines?",
                arrayOf("Philippine Centavo", "Philippine peso (PHP)", "Dirham", "Shequel"), 1),
            Question("What are the most commonly traded currency pairs in the Philippines?",
                arrayOf(" USD/PHP ", "PHP/GBP", "CAD/PHP", "PHP/JPY"), 0),
            Question("What is the equivalent term of BUY/SELL in the forex?",
                arrayOf("Pay/Credit", "Long/Short", "UP/DOWN", "Right/Left"), 1)
        )

        // Display the first question
        displayQuestion()

        // Set up the OnClickListener for the Submit button
        binding.nextAnswerButton.setOnClickListener {
            // Check if the user's answer is correct
            val selectedOptionIndex = getSelectedOptionIndex()
            if (selectedOptionIndex == questions[currentQuestionIndex].correctOptionIndex) {
                score++
            }

            // Move on to the next question
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                // Display the next question
                displayQuestion()
            } else {
                // Show the user's score
                Toast.makeText(this, "Your score is $score", Toast.LENGTH_SHORT).show()

                // Delay for 3 seconds before returning to MainActivity
                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                },3000)
            }
        }
    }

    private fun displayQuestion() {
        // Update the views with the current question
        binding.questionText.text = questions[currentQuestionIndex].text
        binding.optionARadioButton.text = questions[currentQuestionIndex].options[0]
        binding.optionBRadioButton.text = questions[currentQuestionIndex].options[1]
        binding.optionCRadioButton.text = questions[currentQuestionIndex].options[2]
        binding.optionDRadioButton.text = questions[currentQuestionIndex].options[3]

        // Clear the radio buttons
        binding.optionARadioButton.isChecked = false
        binding.optionBRadioButton.isChecked = false
        binding.optionCRadioButton.isChecked = false
        binding.optionDRadioButton.isChecked = false
    }

    private fun getSelectedOptionIndex(): Int {
        when {
            binding.optionARadioButton.isChecked -> return 0
            binding.optionBRadioButton.isChecked -> return 1
            binding.optionCRadioButton.isChecked -> return 2
            binding.optionDRadioButton.isChecked -> return 3
        }
        return -1 // No option is selected
    }
}
