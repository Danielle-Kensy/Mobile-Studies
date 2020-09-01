package com.example.revision

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var buttonDial: Button
    private lateinit var buttonStudent: Button
    private lateinit var buttonSquare: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializer()

        buttonDial.setOnClickListener {
            val intent = Intent (this@MainActivity, dial_screen::class.java)
            startActivity(intent)
            vibrate()
        }

        buttonStudent.setOnClickListener {
            val intent = Intent (this@MainActivity, student_screen::class.java)
            startActivity(intent)
            vibrate()

        }

        buttonSquare.setOnClickListener {
            val intent = Intent (this@MainActivity, square_screen::class.java)
            startActivity(intent)
            vibrate()

        }
    }

    private fun initializer() {
        buttonDial = findViewById(R.id.buttonDial)
        buttonStudent = findViewById(R.id.buttonStudent)
        buttonSquare = findViewById(R.id.buttonSquare)
    }

    private fun vibrate() {
        val pattern = longArrayOf(0, 200, 100, 300)
        val hardware = this@MainActivity.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        hardware?.let {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                hardware.vibrate(VibrationEffect.createWaveform(pattern, -1))
            } else {
                hardware.vibrate(pattern, -1)
            }
        }
    }
}