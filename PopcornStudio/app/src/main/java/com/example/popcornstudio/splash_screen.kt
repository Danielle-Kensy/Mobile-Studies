package com.example.popcornstudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager

class splash_screen : AppCompatActivity() {

    private var delayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 3000 //3 seconds

    internal val runnable = Runnable {
        if(!isFinishing) {
            val intent = Intent(this@splash_screen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        delayHandler = Handler()
        delayHandler!!.postDelayed(runnable, SPLASH_DELAY)


    }

    override fun onDestroy() {
        super.onDestroy()

        delayHandler?.let {
            it.removeCallbacks(runnable)
        }
    }

}