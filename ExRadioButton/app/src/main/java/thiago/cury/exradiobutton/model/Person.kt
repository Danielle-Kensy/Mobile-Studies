package thiago.cury.exradiobutton.model

class Person(var gender: String) {

    public fun verifyGender() : String {
        when (this.gender) {
            "Male" -> {
                return "You are male"
            }
            "Female" -> {
                return "You are female"
            }
            else -> {
                return "You are nothing..."
            }
        }
    }

    override fun toString(): String {
        return "Person(gender='$gender')"
    }
}