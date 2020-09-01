package com.example.thelastairbenderquizz

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.example.thelastairbenderquizz.extension.toast
import com.example.thelastairbenderquizz.model.Quiz
import kotlinx.android.synthetic.main.activity_4.*

class Activity4 : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)
        activity4ButtonNext.visibility = View.INVISIBLE

        Quiz.context= this@Activity4
        Quiz.generateQuestions()
        Quiz.questionsShuffle()
        val questions = Quiz.questionsArray.get(0)

        getScore()

        activity4TextViewDescription.text = questions.questionDescription
        activity4RadioGroupOption1.text = questions.option1
        activity4RadioGroupOption2.text = questions.option2
        activity4RadioGroupOption3.text = questions.option3

        activity4ButtonAnswer.setOnClickListener {
            activity4ButtonNext.visibility = View.VISIBLE
            activity4ButtonAnswer.visibility = View.INVISIBLE

            val id = activity4RadioGroup.checkedRadioButtonId
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

        activity4ButtonNext.setOnClickListener {
            startActivity(Intent(this@Activity4, Activity5::class.java))
            finish()
        }
    }

    fun getScore() {
        activity4TextViewScore.text = Quiz.score().toString()
    }

    private fun play(sound: Int) {
        mediaPlayer = MediaPlayer.create(this@Activity4, sound)
        mediaPlayer.start()
    }

    private fun stop() {
        if(mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
    }
}