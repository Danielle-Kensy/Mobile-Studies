package thiago.cury.exspinnercomarrayadapter.model

class Person(var gender: String) {

    public fun verifyGender(): String {
        when(this.gender) {
            "Male" -> {
                return "You are male"
            }
            "Female" -> {
                return "You are female"
            }
            else -> {
                return "You are nothing, Jon Snow!"
            }
        }
    }

    override fun toString(): String {
        return "Person(gender='$gender')"
    }
}