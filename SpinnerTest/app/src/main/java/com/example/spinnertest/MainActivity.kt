package com.example.spinnertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.spinnertest.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName : EditText
    private lateinit var spinnerGender: Spinner
    private lateinit var layout: ConstraintLayout
    private lateinit var buttonConfirm: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializer()

        buttonConfirm.setOnClickListener {

            val gender = spinnerGender.selectedItem.toString()

            if(spinnerGender.selectedItemPosition == 0) {
                toast("Select a gender")
                layout.setBackgroundColor(getColor(R.color.red100))
                return@setOnClickListener
            } else if(spinnerGender.selectedItemPosition == 1) {
                layout.setBackgroundColor(getColor(R.color.purple100))
                return@setOnClickListener
            } else if(spinnerGender.selectedItemPosition == 2) {
                layout.setBackgroundColor(getColor(R.color.green100))
                return@setOnClickListener
            } else
            layout.setBackgroundColor(getColor(R.color.blue100))
        }


        spinnerGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {}

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p2 != 0) {

                    val user = User(spinnerGender.getItemAtPosition(p2).toString(), editTextName.text.toString(), this@MainActivity)

                    toast("${user.toString()}")
                }
            }
        }

    }

    private fun toast(message: String) {
        Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
    }

    private fun initializer() {
        spinnerGender = findViewById(R.id.spinnerGender)
        editTextName = findViewById(R.id.editTextName)
        layout = findViewById(R.id.layout)
        buttonConfirm = findViewById(R.id.buttonConfirm)
    }
}