package juliano.correa.final_project.model

import java.io.Serializable

data class Character(
    val id: Int,
    var name: String,
    var race: String,
    var age: Int,
    var gender: String,
    var primaryWeapon: String,
    var HP: Double,
    var MP: Double,
    var height: Double,
    var secondaryWeapon: String
): Serializable {
    override fun toString(): String {
        return "Character(id=$id, name='$name', race='$race', age=$age, gender='$gender', primaryWeapon='$primaryWeapon', HP=$HP, MP=$MP, Height=$height, secondaryWeapon='$secondaryWeapon')"
    }
}