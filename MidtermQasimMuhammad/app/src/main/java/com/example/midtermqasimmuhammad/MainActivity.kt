package com.example.midtermqasimmuhammad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var litersInputEditText: EditText
    private lateinit var convertButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        litersInputEditText = findViewById(R.id.litersInputEditText)
        convertButton = findViewById(R.id.convertButton)
        resultTextView = findViewById(R.id.resultTextView)

        // Set click listener for convert button
        convertButton.setOnClickListener {
            // Retrieve input from EditText
            val litersStr = litersInputEditText.text.toString()
            if (litersStr.isNotEmpty()) {
                val liters = litersStr.toDouble()
                val gallons = convertLitersToGallons(liters)
                resultTextView.text = String.format("%.2f liters = %.2f gallons", liters, gallons)
            } else {
                resultTextView.text = "Please enter a valid number of liters"
            }
        }
    }

    // Function to convert liters to gallons
    private fun convertLitersToGallons(liters: Double): Double {
        return liters * 0.219
    }
}
