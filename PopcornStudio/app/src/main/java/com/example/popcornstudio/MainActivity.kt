package com.example.popcornstudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.popcornstudio.model.Movie

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var spinnerYear : Spinner
    private lateinit var spinnerType: Spinner
    private lateinit var radioGroupAvaliation: RadioGroup
    private lateinit var buttonRegister: Button
    private lateinit var textViewResponse: TextView
    private lateinit var layout: ConstraintLayout
    private lateinit var adapter: ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializer()


        buttonRegister.setOnClickListener {

            val gender = spinnerYear.selectedItem.toString()

            if(spinnerYear.selectedItemPosition == 0) {
                toast("Select a year")
                layout.setBackgroundColor(getColor(R.color.yellow100))
                return@setOnClickListener
            } else if(spinnerYear.selectedItemPosition == 1) {
                layout.setBackgroundColor(getColor(R.color.orange100))
                return@setOnClickListener
            } else if(spinnerYear.selectedItemPosition == 2) {
                layout.setBackgroundColor(getColor(R.color.green100))
                return@setOnClickListener
            } else
                layout.setBackgroundColor(getColor(R.color.blue100))
        }


        spinnerYear.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {}

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p2 != 0) {

                    val year = spinnerYear.getItemAtPosition(p2).toString()

                    toast("${year.toString()}")
                }
            }
        }

        spinnerType.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 != 0) {
                    val type = spinnerType.getItemAtPosition(p2).toString()
                    toast("${type.toString()}")
//                    Toast.makeText(baseContext, type.verifyType(), Toast.LENGTH_LONG).show()
                }
            }
        }

        radioGroupAvaliation.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)

                val movie = Movie(editTextName.text.toString(), spinnerYear.selectedItem.toString().toInt(), spinnerType.selectedItem.toString(), radio.text.toString(), this@MainActivity)

                textViewResponse.text = movie.toString() +  "\n" + movie.verifyAvaliation() + "\n" + movie.verifyType()
            }
        )

        buttonRegister.setOnClickListener {
            if(radioGroupAvaliation.checkedRadioButtonId != -1) {

                val radio: RadioButton = findViewById(radioGroupAvaliation.checkedRadioButtonId)

                val movie = Movie(editTextName.text.toString(), spinnerYear.selectedItem.toString().toInt() , spinnerType.selectedItem.toString(), radio.toString(), this@MainActivity)

                Toast.makeText(baseContext, movie.toString(), Toast.LENGTH_LONG).show()
                Toast.makeText(baseContext, movie.verifyAvaliation(), Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(baseContext, "Select a recommendation!", Toast.LENGTH_LONG).show()
            }
        }


    }

    private fun toast(message: String) {
        Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
    }

    private fun initializer() {
        editTextName = findViewById(R.id.editTextName)
        spinnerYear = findViewById(R.id.spinnerYear)
        spinnerType = findViewById(R.id.spinnerType)
        radioGroupAvaliation = findViewById(R.id.RadioGroup)
        buttonRegister = findViewById(R.id.buttonRegister)
        textViewResponse = findViewById(R.id.textViewResponse)
        layout = findViewById(R.id.layout)

        val listType = arrayOf("Select a type", "Comedy", "Action", "Horror")

        adapter = ArrayAdapter(
            this@MainActivity,
            android.R.layout.simple_dropdown_item_1line,
            listType)

        spinnerType.adapter = adapter
    }
}