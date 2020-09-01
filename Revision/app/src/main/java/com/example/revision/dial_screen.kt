package com.example.revision

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class dial_screen : AppCompatActivity() {

    private lateinit var editTextNumberPhone : EditText
    private lateinit var buttonMakeDial: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dial_screen)

        val actionBar = supportActionBar
        initializer()
        actionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
        }

        buttonMakeDial.setOnClickListener {
            val phone = editTextNumberPhone.text.toString()
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${phone}"))
            startActivity(intent)
        }
    }

    private fun initializer() {
        editTextNumberPhone = findViewById(R.id.editTextNumberPhone)
        buttonMakeDial = findViewById(R.id.buttonMakeDial)
    }
}