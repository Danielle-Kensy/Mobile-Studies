package com.example.mineproj

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Screen1 : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var buttonCreeper:Button
    private lateinit var buttonSpider:Button
    private lateinit var buttonCow:Button
    private lateinit var buttonZoombie:Button
    private lateinit var buttonSheep:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

        initializer()

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        buttonCreeper.setOnClickListener {
            play(R.raw.creeper)
        }

        buttonSpider.setOnClickListener {
            play(R.raw.spider)
        }

        buttonCow.setOnClickListener {
            play(R.raw.cow)
        }

        buttonZoombie.setOnClickListener {
            play(R.raw.zombie)
        }

        buttonSheep.setOnClickListener {
            play(R.raw.sheep)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onStop() {
        stop()
        super.onStop()
    }

    private fun initializer() {
        buttonCreeper = findViewById(R.id.buttonCreeper)
        buttonSpider = findViewById(R.id.buttonSpider)
        buttonCow = findViewById(R.id.buttonCow)
        buttonZoombie = findViewById(R.id.buttonZoombie)
        buttonSheep = findViewById(R.id.buttonSheep)
    }

    private fun play(sound: Int) {
        mediaPlayer = MediaPlayer.create(this@Screen1, sound)
        mediaPlayer.start()
    }

    private fun stop() {
        if(mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
    }
}