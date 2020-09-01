package com.example.logintest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val TAG_LOG_MAIN_ACTIVITY: String = "Log MainActivity"
    private lateinit var editTextLogin: EditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(TAG_LOG_MAIN_ACTIVITY, "Entrou no onCreate")

        initializer()

        buttonLogin.setOnClickListener {
            if(editTextLogin.text.toString().isNotEmpty()) {
                val value = editTextLogin.text.toString()

                editTextLogin.text.clear()

                val intent = Intent(this@MainActivity, Screen1::class.java)
                intent.putExtra("value", value)
                startActivity(intent)

            } else {
                Toast.makeText(baseContext, "Preencha o valor...", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG_LOG_MAIN_ACTIVITY, "Entrou no onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG_LOG_MAIN_ACTIVITY, "Entrou no onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG_LOG_MAIN_ACTIVITY, "Entrou no onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG_LOG_MAIN_ACTIVITY, "Entrou no onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG_LOG_MAIN_ACTIVITY, "Entrou no onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG_LOG_MAIN_ACTIVITY, "Entrou no onRestart")
    }
    private fun initializer() {
        Log.i(TAG_LOG_MAIN_ACTIVITY, "Entrou no initializer")
        editTextLogin = findViewById(R.id.editTextLogin)
        buttonLogin = findViewById(R.id.buttonLogin)
    }
}