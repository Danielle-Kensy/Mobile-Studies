package com.example.logintest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Screen1 : AppCompatActivity() {

    private val TAG_LOG_MAIN_ACTIVITY: String = "Log MainActivity"
    private lateinit var textViewResponse: TextView
    private lateinit var editTextTypeUrl : EditText
    private lateinit var buttonBrowse : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

        Log.i(TAG_LOG_MAIN_ACTIVITY, "Entrou no onCreate")

        initializer()

        val value = intent.getStringExtra("value")

        Toast.makeText(baseContext, "Login: $value", Toast.LENGTH_LONG).show()

        textViewResponse.text = "You are Logged " + value

        buttonBrowse.setOnClickListener {
            val URL = editTextTypeUrl.text.toString()

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://${URL}"))
            startActivity(intent)

        }

    }

    private fun initializer() {
        Log.i(TAG_LOG_MAIN_ACTIVITY, "Entrou no initializer")
        textViewResponse = findViewById(R.id.textViewResponse)
        editTextTypeUrl = findViewById(R.id.editTextTypeUrl)
        buttonBrowse = findViewById(R.id.buttonBrowse)
    }
}