package juliano.correa.final_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import juliano.correa.final_project.extensions.toast
import juliano.correa.final_project.model.Character
import juliano.correa.final_project.service.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_4.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Activity4 : AppCompatActivity() {

    private lateinit var character: juliano.correa.final_project.model.Character

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)

        buttonCharacterList.setOnClickListener {startActivity(Intent(this@Activity4, Activity5::class.java))}

        progressBar.visibility = View.INVISIBLE

        if(intent.hasExtra("${R.string.add_character}")) {
            character = intent.getSerializableExtra("${R.string.add_character}") as juliano.correa.final_project.model.Character

            if (character != null) {
                toast("${R.string.add_is_not_null}")

                buttonRegisterCharacter.setText("${R.string.add_update_character}")

                editTextNameCharacter.setText(character.name)
                editTextAgeCharacter.setText(character.age)
                editTextMpCharacter.setText(character.MP.toString())
                editTextHpCharacter.setText(character.HP.toString())
                editTextHeightCharacter.setText(character.height.toString())
                character.race = spinnerRacesCharacter.selectedItem.toString()
                character.gender = spinnerGenderCharacter.selectedItem.toString()
                character.primaryWeapon = spinnerPrimaryWeaponCharacter.selectedItem.toString()
                character.secondaryWeapon = spinnerSecondaryWeaponCharacter.selectedItem.toString()

            }
        }

        buttonRegisterCharacter.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            if(intent.hasExtra("${R.string.add_character}")) {
                character.name = editTextNameCharacter.text.toString()
                character.race = spinnerRacesCharacter.selectedItem.toString()
                character.age = editTextAgeCharacter.text.toString().toInt()
                character.gender = spinnerGenderCharacter.selectedItem.toString()
                character.primaryWeapon = spinnerPrimaryWeaponCharacter.selectedItem.toString()
                character.HP = editTextHpCharacter.text.toString().toDouble()
                character.MP = editTextMpCharacter.text.toString().toDouble()
                character.height = editTextHeightCharacter.text.toString().toDouble()
                character.secondaryWeapon = spinnerSecondaryWeaponCharacter.selectedItem.toString()

                update()
            } else {
                save()
            }
        }

    }

    private fun save() {
        character = Character(-20, editTextNameCharacter.text.toString(),spinnerRacesCharacter.selectedItem.toString(), editTextAgeCharacter.text.toString().toInt(), spinnerGenderCharacter.selectedItem.toString(),spinnerPrimaryWeaponCharacter.selectedItem.toString(),editTextHpCharacter.text.toString().toDouble(),editTextMpCharacter.text.toString().toDouble(),editTextHeightCharacter.text.toString().toDouble(),spinnerSecondaryWeaponCharacter.selectedItem.toString() )
        val call = RetrofitInitializer().characterService().save(character)

        call.enqueue(object : Callback<juliano.correa.final_project.model.Character> {
            override fun onFailure(call: Call<Character>, t: Throwable) {
                progressBar.visibility = View.INVISIBLE
                toast("${R.string.list_error}: ${t.toString()}")
            }

            override fun onResponse(call: Call<juliano.correa.final_project.model.Character>, response: Response<juliano.correa.final_project.model.Character>) {
                progressBar.visibility = View.INVISIBLE
                if(response.isSuccessful) {
                    character = response.body() as juliano.correa.final_project.model.Character
                    toast("${R.string.list_return_code}: ${response.code()}") //201 - created
                    toast("${R.string.add_character_registered}: ${character.toString()}")
                }
            }
        })
    }

    private fun update() {
        val call = RetrofitInitializer().characterService().update(this.character)

        call.enqueue(object : Callback<juliano.correa.final_project.model.Character> {
            override fun onFailure(call: Call<juliano.correa.final_project.model.Character>, t: Throwable) {
                progressBar.visibility = View.INVISIBLE
                toast("${R.string.list_error} ${t.toString()}")
            }

            override fun onResponse(call: Call<juliano.correa.final_project.model.Character>, response: Response<juliano.correa.final_project.model.Character>) {
                progressBar.visibility = View.INVISIBLE
                toast("${R.string.list_return_code}: ${response.code()}")
                if(response.isSuccessful) {
                    val character = response.body() as juliano.correa.final_project.model.Character
                    toast("${R.string.add_character_updated_return}: ${character.toString()}")
                }
            }
        })
    }
}