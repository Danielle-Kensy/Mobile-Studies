package com.example.month.model

import android.content.Context
import com.example.month.R

class Month (var number: Int, val context: Context) {

    fun verifyMonth(): String {

        when(number) {
            1 -> return "${context.getString(R.string.m1)}"
            2 -> return "${context.getString(R.string.m2)}"
            3 -> return "${context.getString(R.string.m3)}"
            4 -> return "${context.getString(R.string.m4)}"
            5 -> return "${context.getString(R.string.m5)}"
            6 -> return "${context.getString(R.string.m6)}"
            7 -> return "${context.getString(R.string.m7)}"
            8 -> return "${context.getString(R.string.m8)}"
            9 -> return "${context.getString(R.string.m9)}"
            10 -> return "${context.getString(R.string.m10)}"
            11 -> return "${context.getString(R.string.m11)}"
            12 -> return "${context.getString(R.string.m12)}"
            else -> return "${context.getString(R.string.error)}"
        }
    }

}