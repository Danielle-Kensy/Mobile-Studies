package com.example.horncalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNameOne : EditText
    private lateinit var editTextNameTwo : EditText
    private lateinit var buttonCalculate : Button
    private lateinit var textViewResponse : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Refs
        editTextNameOne = findViewById(R.id.editTextNameOne)
        editTextNameTwo = findViewById(R.id.editTextNameTwo)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        textViewResponse = findViewById(R.id.textViewResponse)

        buttonCalculate.setOnClickListener {
            var nameOne = editTextNameOne.text.toString()

            val random = (0..100).random()
            val response = "${getText(R.string.your_name)} $nameOne \n${getText(R.string.you_are)} $random % ${getText(R.string.horn)}!!"

            textViewResponse.text = response

            clean()

        }

    }
    private fun clean() {
        editTextNameOne.text.clear()
        editTextNameTwo.text.clear()
    }
}