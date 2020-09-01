package com.example.thelastairbenderquizz

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart.setOnClickListener {
            vibrate()
            startActivity(Intent(this@MainActivity, Activity1::class.java))}}

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