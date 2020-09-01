package com.example.revision

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.example.revision.model.Square

class square_screen : AppCompatActivity() {

    private lateinit var editTextSquare : EditText
    private lateinit var spinnerSquare : Spinner
    private lateinit var buttonCalculate : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square_screen)

        val actionBar = supportActionBar
        initializer()
        actionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
        }

        buttonCalculate.setOnClickListener {
            val square = Square(editTextSquare.text.toString().toDouble(), this@square_screen)
            val response = spinnerSquare.selectedItem.toString()

            if(response.contentEquals("Area")) {
                toast("${square.calculateArea()}")
            } else if(response.contentEquals("Perimeter")) {
                toast("${square.calculatePerimeter()}")
            } else {
                toast("${square.calculateArea()} \n ${square.calculatePerimeter()}")
            }
            clear()

        }


    }

    private fun initializer() {
        editTextSquare = findViewById(R.id.editTextSquare)
        spinnerSquare = findViewById(R.id.spinnerSquare)
        buttonCalculate = findViewById(R.id.buttonCalculate)
    }

    private fun toast(message: String) {
        Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
    }

    private fun clear() {
        editTextSquare.text.clear()
    }
}