package com.example.thelastairbenderquizz

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.example.thelastairbenderquizz.extension.toast
import com.example.thelastairbenderquizz.model.Quiz
import kotlinx.android.synthetic.main.activity_2.*

class Activity2 : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        activity2ButtonNext.visibility = View.INVISIBLE

        Quiz.context= this@Activity2
        Quiz.generateQuestions()
        Quiz.questionsShuffle()
        val questions = Quiz.questionsArray.get(0)

        getScore()

        activity2TextViewDescription.text = questions.questionDescription
        activity2RadioGroupOption1.text = questions.option1
        activity2RadioGroupOption2.text = questions.option2
        activity2RadioGroupOption3.text = questions.option3

        activity2ButtonAnswer.setOnClickListener {
            activity2ButtonNext.visibility = View.VISIBLE
            activity2ButtonAnswer.visibility = View.INVISIBLE

            val id = activity2RadioGroup.checkedRadioButtonId
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

        activity2ButtonNext.setOnClickListener {
            startActivity(Intent(this@Activity2, Activity3::class.java))
            finish()
        }
    }

    fun getScore() {
        activity2TextViewScore.text = Quiz.score().toString()
    }

    private fun play(sound: Int) {
        mediaPlayer = MediaPlayer.create(this@Activity2, sound)
        mediaPlayer.start()
    }

    private fun stop() {
        if(mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
    }
}