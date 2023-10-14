package com.example.ticketapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ticketapp.databinding.ActivityOrdersummaryBinding

class ordersummary : AppCompatActivity() {

    private lateinit var binding: ActivityOrdersummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrdersummaryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Ambil data dari paymentmethod
        val bioskop = intent.getStringExtra("bioskop")
        val seat = intent.getStringExtra("seat")
        val paymentMethod = intent.getStringExtra("paymentMethod")
        val bank = intent.getStringExtra("bank")
        val tanggal = intent.getStringExtra("tanggal")
        val nomor = intent.getStringExtra("nomor")


        // Setel data ke tampilan
        binding.bioskopSummary.text = "Bioskop: $bioskop"
        binding.seatSummary.text = "Seat: $seat"
        binding.paymentSummary.text = "Payment Method: $paymentMethod"
        binding.bankSummary.text = "Bank: $bank"
        binding.dateSummary.text = "Tanggal: $tanggal"
    }
}
