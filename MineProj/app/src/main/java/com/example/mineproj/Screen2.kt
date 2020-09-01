package com.example.mineproj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Screen2 : AppCompatActivity() {

    private lateinit var editTextItems: EditText
    private lateinit var editTextLevel: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var textViewResponse : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)

        editTextItems = findViewById(R.id.editTextItems)
        editTextLevel = findViewById(R.id.editTextLevel)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        textViewResponse = findViewById(R.id.textViewResponse)

        buttonCalculate.setOnClickListener {
            var item = editTextItems.text.toString().toInt()
            var level = editTextLevel.text.toString().toInt()

            val result = level * item

            val response = "${getText(R.string.your_power_is)} $result"

            textViewResponse.text = response

            clean()
        }


        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun clean() {
        editTextItems.text.clear()
        editTextLevel.text.clear()
    }
}