package com.alarcon.myactivity4

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alarcon.myactivity4.databinding.ActivityQuestionAnswerBinding

class HistoryQuestionActivity : AppCompatActivity() {
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
            Question(
                "Who was the first President of the Philippines?",
                arrayOf("Tito Sotto", "Emilio Aguinaldo", "Vic Sotto", "Kai Sotto"), 1
            ),
            Question(
                "What was the name of the Philippine revolution against Spanish rule that began in 1896?",
                arrayOf(
                    "The Katinka Revolution",
                    " The EDS Revolution",
                    "The Philippine-American War",
                    "Option 4"
                ), 0
            ),
            Question(
                "Who is the first female president of the Philippines, who served from 1986 to 1992? ",
                arrayOf(
                    "Gloria Macapa-gal Arroyo",
                    "Corazon Aquino",
                    "Miriam Santiago",
                    "Kris Aquino"
                ), 1
            )
        )

        displayQuestion()

        binding.nextAnswerButton.setOnClickListener {
            // Check if the user's answer is correct
            val selectedOptionIndex = getSelectedOptionIndex()
            if (selectedOptionIndex == questions[currentQuestionIndex].correctOptionIndex) {
                score++
            }
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                displayQuestion()
            } else {
                Toast.makeText(this, "Your score is $score", Toast.LENGTH_SHORT).show()
                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }, 3000)
            }
        }


    }


    private fun displayQuestion() {

        binding.questionText.text = questions[currentQuestionIndex].text
        binding.optionARadioButton.text = questions[currentQuestionIndex].options[0]
        binding.optionBRadioButton.text = questions[currentQuestionIndex].options[1]
        binding.optionCRadioButton.text = questions[currentQuestionIndex].options[2]
        binding.optionDRadioButton.text = questions[currentQuestionIndex].options[3]


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
        return -1
    }
}