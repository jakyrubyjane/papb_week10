package com.example.ticketapp

import android.R
import android.content.Intent
import java.io.Serializable
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.ticketapp.databinding.ActivityPaymentmethodBinding

class paymentmethod : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentmethodBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityPaymentmethodBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Inisialisasi Spinner untuk Pilih Bioskop
        val bioskopSpinner = binding.option
        val bioskopOptions =
            arrayOf("Ambarukmo Plaza", "Sleman City Hall", "Pakuwon Mall") // Ganti dengan pilihan sesuai kebutuhan
        val bioskopAdapter = ArrayAdapter(this, R.layout.simple_spinner_item, bioskopOptions)
        bioskopAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        bioskopSpinner.adapter = bioskopAdapter

        // Inisialisasi Spinner untuk Pilih Jenis Seat
        val seatSpinner = binding.seat
        val seatOptions =
            arrayOf("Executive", "Premium", "Regular") // Ganti dengan pilihan sesuai kebutuhan
        val seatAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, seatOptions)
        seatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        seatSpinner.adapter = seatAdapter

        // Inisialisasi Spinner untuk Add Payment Method
        val paymentSpinner = binding.payment
        val paymentOptions =
            arrayOf("Credit Card", "Debit Card", "Cash On Delivery") // Ganti dengan pilihan sesuai kebutuhan
        val paymentAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, paymentOptions)
        paymentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        paymentSpinner.adapter = paymentAdapter

        // Inisialisasi Spinner untuk Pilih Bank
        val bankSpinner = binding.bankoption
        val bankOptions =
            arrayOf("BNI", "BCA", "BRI") // Ganti dengan pilihan sesuai kebutuhan
        val bankAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, bankOptions)
        bankAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        bankSpinner.adapter = bankAdapter

        // Inisialisasi DatePicker
        val datePicker = binding.jadwaltanggal
        datePicker.init(
            2023,
            9,
            14,
            null
        )

        // Lanjutkan dengan menambahkan event listener atau logika lain sesuai kebutuhan.
        val AppCompatButton = binding.summbutton

        AppCompatButton.setOnClickListener {
            val intent = Intent(this, ordersummary::class.java)
            startActivity(intent)
        }
        // ...

// Setel OnClickListener untuk tombol Order Summary
        binding.summbutton.setOnClickListener {
            val selectedBioskop = bioskopSpinner.selectedItem.toString()
            val selectedSeat = seatSpinner.selectedItem.toString()
            val selectedPaymentMethod = paymentSpinner.selectedItem.toString()
            val selectedBank = bankSpinner.selectedItem.toString()

            // Ambil tanggal dari DatePicker
            val year = datePicker.year
            val month = datePicker.month
            val day = datePicker.dayOfMonth
            val selectedDate = String.format("%04d-%02d-%02d", year, month + 1, day)

            // Mulai aktivitas ordersummary
            val intent = Intent(this, ordersummary::class.java).apply {
                putExtra("bioskop", selectedBioskop)
                putExtra("seat", selectedSeat)
                putExtra("paymentMethod", selectedPaymentMethod)
                putExtra("bank", selectedBank)
                putExtra("tanggal", selectedDate)


            }
            startActivity(intent)
        }

// ...

    }
}
