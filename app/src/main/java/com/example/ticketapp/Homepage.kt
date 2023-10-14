package com.example.ticketapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ticketapp.databinding.ActivityHomepageBinding

class Homepage : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("USERNAME")

        if (username != null) {
            binding.welcome.text = "$username!"
        }

        val imageView = binding.imageView3

        imageView.setOnClickListener {
            val intent = Intent(this, film1::class.java)
            startActivity(intent)


        }
    }
}
