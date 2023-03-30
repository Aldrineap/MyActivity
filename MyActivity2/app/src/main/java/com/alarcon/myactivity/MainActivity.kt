package com.alarcon.myactivity

    import android.content.Intent
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Handler
    import android.os.Looper
    import android.os.Bundle
    import com.alarcon.myactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // access views using binding
        binding.logoImageView // access logoImageView using binding
        binding.titleTextView // access titleTextView using binding
        binding.subtitleTextView1 // access subtitleTextView1 using binding
        binding.subtitleTextView2 // access subtitleTextView2 using binding
        binding.subtitleTextView3 // access subtitleTextView3 using binding

        binding.root.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, ActivitySignUp::class.java)
                startActivity(intent)
                finish()
            }, 2000)
        }
    }
}