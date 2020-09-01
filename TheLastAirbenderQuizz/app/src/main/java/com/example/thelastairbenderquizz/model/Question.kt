package com.example.thelastairbenderquizz.model

import android.content.Context

class Question(
    var questionDescription: String,
    var option1: String,
    var option2: String,
    var option3: String,
    var correctOptionAnswer: String) {

    var correctAnswer: Boolean = false

    override fun toString(): String {
        return "Question(questionDescription='$questionDescription', option1='$option1', option2='$option2', option3='$option3', correctOptionAnswer='$correctOptionAnswer', correctAnswer=$correctAnswer)"
    }
}