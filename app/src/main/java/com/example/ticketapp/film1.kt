package com.example.ticketapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.ticketapp.databinding.ActivityFilm1Binding // Sesuaikan dengan nama package Anda

class film1 : AppCompatActivity() {
    private lateinit var binding: ActivityFilm1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilm1Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val AppCompatButton = binding.buybutton

        AppCompatButton.setOnClickListener {
            val intent = Intent(this, paymentmethod::class.java)
            startActivity(intent)

    }
    }
}




