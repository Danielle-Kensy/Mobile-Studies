package juliano.correa.final_project

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import juliano.correa.final_project.adapter.CharacterAdapter
import juliano.correa.final_project.extensions.toast
import juliano.correa.final_project.model.Character
import juliano.correa.final_project.service.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_5.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Activity5 : AppCompatActivity() {

    private lateinit var adapter: CharacterAdapter
    private var characters = arrayListOf<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_5)
        initializer()
        loadData()

    }

    private fun initializer() {
        listCharacterProgressBar.visibility = View.INVISIBLE

        adapter = CharacterAdapter(
            characters,
            this@Activity5,
            { character: Character -> resultItemClicked(character)})

        recyclerViewCharacter.adapter = adapter
        recyclerViewCharacter.layoutManager = LinearLayoutManager(this@Activity5)
    }

    private fun resultItemClicked(character: Character) {
//        toast("clicou no character: ${character.toString()}")

        val dialogBuilder = AlertDialog.Builder(this@Activity5)

        val alert = dialogBuilder
            .setTitle("${R.string.list_attention}")
            .setMessage("${R.string.list_delete_or_update}")
            .setPositiveButton("${R.string.list_delete}", DialogInterface.OnClickListener {
                    dialog, id ->

                remove(character)

            })
            .setNegativeButton("${R.string.list_update}", DialogInterface.OnClickListener{
                    dialog, id ->

                val intent = Intent(this@Activity5, Activity4::class.java)
                intent.putExtra("${R.string.list_character}", character)
                startActivity(intent)
                finish()

            }).create()
        alert.show()
    }

    private fun remove(character: Character) {
        listCharacterProgressBar.visibility = View.VISIBLE

        val call = RetrofitInitializer().characterService().delete(character.id)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                listCharacterProgressBar.visibility = View.INVISIBLE
                toast("${R.string.list_error}: ${t.toString()}")
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                listCharacterProgressBar.visibility = View.INVISIBLE
                if(response.isSuccessful) {
                    if(response.code() == 200) {
                        toast("${R.string.list_delete_character}")

                        characters.remove(character)
                        adapter.notifyNewData()

                    }
                }
            }
        })
    }

    private fun loadData() {
        listCharacterProgressBar.visibility = View.VISIBLE

        val call = RetrofitInitializer().characterService().findAll()

        call.enqueue(object : Callback<List<Character>> {
            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                listCharacterProgressBar.visibility = View.INVISIBLE
                toast("${R.string.list_error} ${t.toString()}")
            }

            override fun onResponse(call: Call<List<Character>>, response: Response<List<Character>>) {
                listCharacterProgressBar.visibility = View.INVISIBLE

                toast("${R.string.list_return_code}: ${response.code()}") //200

                val newCharacters: List<Character>? = response.body()
                newCharacters?.let {
                    for(character in it) {
                        characters.add(character)
                    }
                    adapter.notifyNewData()
                }
            }
        })
    }
}