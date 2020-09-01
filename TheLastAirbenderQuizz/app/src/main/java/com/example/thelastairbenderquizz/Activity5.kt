package com.example.thelastairbenderquizz

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.RadioButton
import com.example.thelastairbenderquizz.extension.toast
import com.example.thelastairbenderquizz.model.Quiz
import kotlinx.android.synthetic.main.activity_5.*

class Activity5 : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_5)
        activity5ButtonNext.visibility = View.INVISIBLE

        Quiz.context= this@Activity5
        Quiz.generateQuestions()
        Quiz.questionsShuffle()
        val questions = Quiz.questionsArray.get(0)

        getScore()

        activity5TextViewDescription.text = questions.questionDescription
        activity5RadioGroupOption1.text = questions.option1
        activity5RadioGroupOption2.text = questions.option2
        activity5RadioGroupOption3.text = questions.option3

        activity5ButtonAnswer.setOnClickListener {
            activity5ButtonNext.visibility = View.VISIBLE
            activity5ButtonAnswer.visibility = View.INVISIBLE

            val id = activity5RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if(Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast("${getText(R.string.right)}")
                play(R.raw.right)
                getScore()
            } else {
                toast("${getText(R.string.wrong)}")
                play(R.raw.wrong)
            }
        }

        activity5ButtonNext.setOnClickListener {
            vibrate()
            startActivity(Intent(this@Activity5, FinalQuiz::class.java))
            finish()
        }
    }

    fun getScore() {
        activity5TextViewScore.text = Quiz.score().toString()
    }

    private fun vibrate() {
        val pattern = longArrayOf(0, 200, 100, 300)
        val hardware = this@Activity5.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        hardware?.let {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                hardware.vibrate(VibrationEffect.createWaveform(pattern, -1))
            } else {
                hardware.vibrate(pattern, -1)
            }
        }
    }

    private fun play(sound: Int) {
        mediaPlayer = MediaPlayer.create(this@Activity5, sound)
        mediaPlayer.start()
    }

    private fun stop() {
        if(mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
    }
}