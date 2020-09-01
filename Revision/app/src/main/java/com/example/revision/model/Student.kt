package com.example.revision.model

import android.content.Context

class Student (var name : String, var grade1 : Double, var grade2 : Double, context: Context) {

    fun calculateAverage(): Double {
        return (grade1 + grade2) /2
    }

    fun verifyAvarage(): String {
        if (calculateAverage()>=6) {
            return "Approved: " + calculateAverage()
        } else {
            return "Reproved: " + calculateAverage()
        }
    }

    override fun toString(): String {
        return "Student Name: $name " +
                "\nGrade1: $grade1 " +
                "\nGrade2: $grade2 " +
                "\nAverage: ${calculateAverage()}"
    }


}