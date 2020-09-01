package com.example.thelastairbenderquizz

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import com.example.thelastairbenderquizz.model.Quiz
import kotlinx.android.synthetic.main.activity_final_quiz.*

class FinalQuiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_quiz)

        getScore()

        finalQuizTextViewCorrectAnswers.text = "${Quiz.checkAverageOfCorrectAnswers()}%"

        finalQuizTextViewFinalMessage.text = Quiz.finalMessage()

        finalQuizButtonPlayAgain.setOnClickListener {
            vibrate()
            Quiz.clearAll()
            startActivity(Intent(this@FinalQuiz, Activity1::class.java))
            finish()
        }
    }

    fun getScore() {
        finalQuizTextViewScore.text = Quiz.score().toString()
    }

    private fun vibrate() {
        val pattern = longArrayOf(0, 200, 100, 300)
        val hardware = this@FinalQuiz.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        hardware?.let {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                hardware.vibrate(VibrationEffect.createWaveform(pattern, -1))
            } else {
                hardware.vibrate(pattern, -1)
            }
        }
    }
}
