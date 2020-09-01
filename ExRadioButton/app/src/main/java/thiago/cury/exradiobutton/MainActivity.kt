package thiago.cury.exradiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import thiago.cury.exradiobutton.model.Person

class MainActivity : AppCompatActivity() {

    private lateinit var radioGroupGender: RadioGroup
//    private lateinit var radioButtonMale: RadioButton
//    private lateinit var radioButtonFemale: RadioButton
    private lateinit var buttonChoose: Button

    private lateinit var textViewResponse: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializer()


        radioGroupGender.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)

                val person = Person(radio.text.toString())

                textViewResponse.text = person.verifyGender()
            }
        )


        buttonChoose.setOnClickListener {
            if(radioGroupGender.checkedRadioButtonId != -1) {
//                    var gender = ""

                    val radio: RadioButton = findViewById(radioGroupGender.checkedRadioButtonId)

//                    if(radioGroupGender.checkedRadioButtonId == radioButtonMale.id) {
//                        gender = radioButtonMale.text.toString()
//                    } else if(radioGroupGender.checkedRadioButtonId == radioButtonFemale.id) {
//                        gender = radioButtonFemale.text.toString()
//                    } else {
//                        gender = "Other...."
//                    }

                    val person = Person(radio.text.toString())

                    Toast.makeText(baseContext, person.toString(), Toast.LENGTH_LONG).show()
                    Toast.makeText(baseContext, person.verifyGender(), Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(baseContext, "Select a gender!", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun initializer() {
        radioGroupGender = findViewById(R.id.radioGroupGender)
//        radioButtonMale = findViewById(R.id.radioButtonMale)
//        radioButtonFemale = findViewById(R.id.radioButtonFemale)
        buttonChoose = findViewById(R.id.buttonChoose)

        textViewResponse = findViewById(R.id.textViewResponse)
    }
}