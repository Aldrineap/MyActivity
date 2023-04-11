package com.alarcon.myactivity3

    import android.content.Intent
    import android.os.Bundle
    import androidx.appcompat.app.AppCompatActivity
    import com.alarcon.myactivity3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.classButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

            binding.libraryButton.setOnClickListener {
            // code to be executed when the libraryButton is clicked
            // add your implementation here
        }

        binding.groceryButton.setOnClickListener {
            // code to be executed when the groceryButton is clicked
            // add your implementation here
        }


    }
}