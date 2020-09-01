package com.example.revision.model

import android.content.Context

class Square (var side: Double, context: Context) {

    fun calculateArea(): String {
       return "Area: " + side * side
    }

    fun calculatePerimeter(): String {
        return "Perimeter: " + side * 4
    }

    override fun toString(): String {
        return "Square side: $side"
    }
}