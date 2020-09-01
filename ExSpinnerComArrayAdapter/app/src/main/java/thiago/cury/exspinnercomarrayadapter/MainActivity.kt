package thiago.cury.exspinnercomarrayadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import thiago.cury.exspinnercomarrayadapter.model.Person

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerGender: Spinner
    private lateinit var buttonChoose: Button

    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializer()

        spinnerGender.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 != 0) {
                    val person = Person(spinnerGender.getItemAtPosition(p2).toString())
                    Toast.makeText(baseContext, person.toString(), Toast.LENGTH_LONG).show()
                    Toast.makeText(baseContext, person.verifyGender(), Toast.LENGTH_LONG).show()
                }
            }
        }
        
        buttonChoose.setOnClickListener {
            if(spinnerGender.selectedItemPosition == 0) {
                Toast.makeText(baseContext, "Please, select a gender!", Toast.LENGTH_LONG).show()
            } else {
                val person = Person(spinnerGender.selectedItem.toString())
                Toast.makeText(baseContext, person.toString(), Toast.LENGTH_LONG).show()
                Toast.makeText(baseContext, person.verifyGender(), Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun initializer() {
        spinnerGender = findViewById(R.id.spinnerGender)
        buttonChoose = findViewById(R.id.buttonChoose)

        val listGender = arrayOf("Select a gender", "Male", "Female")

        adapter = ArrayAdapter(
            this@MainActivity,
            android.R.layout.simple_dropdown_item_1line,
            listGender)

        spinnerGender.adapter = adapter
    }

}