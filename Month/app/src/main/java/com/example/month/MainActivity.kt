package com.example.month

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.month.model.Month

class MainActivity : AppCompatActivity() {

    private lateinit var buttonCheck: Button
    private lateinit var textViewResponse : TextView
    private lateinit var editTextMonth: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializer()

        buttonCheck.setOnClickListener {
            val month = Month(editTextMonth.text.toString().toInt(),this@MainActivity)

            textViewResponse.text = month.verifyMonth()
        }
    }

    private fun initializer() {
        buttonCheck = findViewById(R.id.buttonCheck)
        textViewResponse = findViewById(R.id.textViewResponse)
        editTextMonth = findViewById(R.id.editTextMonth)
    }
}