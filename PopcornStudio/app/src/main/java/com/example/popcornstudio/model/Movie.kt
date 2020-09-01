package com.example.popcornstudio.model

import android.content.Context
import com.example.popcornstudio.R

class Movie (var name: String, var year: Int, var type: String, var avaliation: String, val context: Context) {

    public fun verifyType(): String {
        when(this.type) {
            "Comedy" -> {
                return "You choose comedy"
            }
            "Action" -> {
                return "You choose action"
            }
            else -> {
                return "You choose horror"
            }
        }
    }

    public fun verifyAvaliation(): String {
        when(this.avaliation) {
            "bad" -> {
                return "You don´t like the movie :("
            }
            "good" -> {
                return "Yes you can watch it"
            }
            else -> {
                return "OMG!! THIS MOVIE IS PERFECT :)"
            }
        }
    }


    override fun toString(): String {
        return "${context.getString(R.string.MovieName)} $name" +
                "\n${context.getString(R.string.MovieYear)} $year" +
                "\n${context.getString(R.string.MovieType)} $type " +
                "\n${context.getString(R.string.MovieAvaliation)} $avaliation"
    }
}