package juliano.correa.final_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import juliano.correa.final_project.R
import juliano.correa.final_project.model.Character
import kotlinx.android.synthetic.main.row_characters.view.*

class CharacterAdapter(val characters: List<Character>,
                       val context: Context,
                       val listener: (Character) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_characters, parent, false))
    }

    //1
    override fun getItemCount(): Int {
        return this.characters.size
    }

    //3
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val character = this.characters[position]

        if(holder is ViewHolder) {
            holder.bind(character, position, context, listener)
        }
    }

    public fun notifyNewData() {
        this.notifyDataSetChanged()
    }


//2.0
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(character: Character?,
             position: Int?,
             context: Context,
             listener: (Character) -> Unit) = with(itemView) {

        val rowCharacterTextViewID = itemView.rowCharactersTextViewId
        val rowCharacterTextViewName = itemView.rowCharactersTextViewName
        val rowCharactersTextViewGender = itemView.rowCharactersTextViewGender
        val rowCharactersTextViewRace = itemView.rowCharactersTextViewRace
        val rowCharactersTextViewAge = itemView.rowCharactersTextViewAge
        val rowCharactersTextViewPrimaryWeapon = itemView.rowCharactersTextViewPrimaryWeapon
        val rowCharactersTextViewSecondaryWeapon = itemView.rowCharactersTextViewSecondaryWeapon
        val rowCharactersTextViewHeight = itemView.rowCharactersTextViewHeight
        val rowCharactersTextViewMP = itemView.rowCharactersTextViewMP
        val rowCharactersTextViewHP = itemView.rowCharactersTextViewHP


        character?.let {
            rowCharacterTextViewID.text = it.id.toString()
            rowCharacterTextViewName.text = it.name.toString()
            rowCharactersTextViewGender.text =  it.gender.toString()
            rowCharactersTextViewRace.text = it.race.toString()
            rowCharactersTextViewAge.text = it.age.toString()
            rowCharactersTextViewPrimaryWeapon.text = it.primaryWeapon.toString()
            rowCharactersTextViewSecondaryWeapon.text = it.secondaryWeapon?:"xxx"
            rowCharactersTextViewHeight.text = it.height.toString()
            rowCharactersTextViewMP.text = it.MP.toString()
            rowCharactersTextViewHP.text = it.HP.toString()

            itemView.setOnClickListener { listener(character) }

        }
    }
}}