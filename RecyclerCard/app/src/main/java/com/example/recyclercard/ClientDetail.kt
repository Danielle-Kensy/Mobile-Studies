package com.example.recyclercard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recyclercard.model.Client

class ClientDetail : AppCompatActivity() {

    private lateinit var client: Client

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_detail)

        client = intent.getSerializableExtra("client") as Client

        Toast.makeText(baseContext, "Cliente que chegou: ${client.toString()}", Toast.LENGTH_LONG).show()

    }
}