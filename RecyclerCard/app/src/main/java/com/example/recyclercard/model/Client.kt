package com.example.recyclercard.model

import java.io.Serializable

class Client(
    var id: Long,
    var name: String,
    var gender: String,
    var income: Double) : Serializable {

    override fun toString(): String {
        return "Client(name='$name', gender='$gender', income=$income)"
    }

}