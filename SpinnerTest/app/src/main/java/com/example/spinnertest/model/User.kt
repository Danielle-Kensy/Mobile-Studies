package com.example.spinnertest.model

import android.content.Context
import com.example.spinnertest.R

class User(var gender: String, var name: String, val context: Context) {

    override fun toString(): String {
        return "${context.getString(R.string.your_name_is)} $name " +
                "\n${context.getString(R.string.your_gender_is)} $gender"
    }
}