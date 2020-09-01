package com.example.revision

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.revision.model.Student

class student_screen : AppCompatActivity() {

    private lateinit var editTextName : EditText
    private lateinit var editTextGradeOne : EditText
    private lateinit var editTextGradeTwo : EditText
    private lateinit var buttonAverage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_screen)

        val actionBar = supportActionBar
        initializer()
        actionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
        }

        buttonAverage.setOnClickListener {
           val student = Student(editTextName.text.toString(), editTextGradeOne.text.toString().toDouble(), editTextGradeTwo.text.toString().toDouble(), this@student_screen)

           toast("Aluno foi ${student.verifyAvarage()}")

            clear()

        }

        buttonAverage.setOnLongClickListener(object: View.OnLongClickListener{

            override fun onLongClick(p0: View?): Boolean {
                val student = Student(editTextName.text.toString(), editTextGradeOne.text.toString().toDouble(), editTextGradeTwo.text.toString().toDouble(), this@student_screen)
                var alert = AlertDialog.Builder(this@student_screen)
                alert.setMessage(student.toString())
                alert.setTitle("Student info")
                alert.setIcon(ContextCompat.getDrawable(this@student_screen, R.drawable.student))
                alert.show()
                return true
            }
        })



    }

    private fun initializer() {
        editTextName = findViewById(R.id.editTextName)
        editTextGradeOne = findViewById(R.id.editTextGradeOne)
        editTextGradeTwo = findViewById(R.id.editTextGradeTwo)
        buttonAverage = findViewById(R.id.buttonAverage)

    }

    private fun toast(message: String) {
        Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
    }

    private fun clear() {
        editTextName.text.clear()
        editTextGradeOne.text.clear()
        editTextGradeTwo.text.clear()
    }
}