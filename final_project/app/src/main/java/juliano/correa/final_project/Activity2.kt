package juliano.correa.final_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_2.*

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        buttonAlien.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                var alert1 = AlertDialog.Builder(this@Activity2)
                alert1.setMessage(getText(R.string.alert_alien))
                alert1.setTitle(getText(R.string.alert_alien_title))
                alert1.setIcon(ContextCompat.getDrawable(this@Activity2, R.drawable.alien_png))
                alert1.setNeutralButton(getText(R.string.alert_neutral_button), null)
                alert1.show()
                return true
            }
        })

        buttonHuman.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                var alert1 = AlertDialog.Builder(this@Activity2)
                alert1.setMessage(getText(R.string.alert_human))
                alert1.setTitle(getText(R.string.alert_human_title))
                alert1.setIcon(ContextCompat.getDrawable(this@Activity2, R.drawable.human_png))
                alert1.setNeutralButton(getText(R.string.alert_neutral_button), null)
                alert1.show()
                return true
            }
        })

        buttonElf.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                var alert1 = AlertDialog.Builder(this@Activity2)
                alert1.setMessage(getText(R.string.alert_elf))
                alert1.setTitle(getText(R.string.alert_elf_title))
                alert1.setIcon(ContextCompat.getDrawable(this@Activity2, R.drawable.elf_png))
                alert1.setNeutralButton(getText(R.string.alert_neutral_button), null)
                alert1.show()
                return true
            }
        })

        buttonUndead.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                var alert1 = AlertDialog.Builder(this@Activity2)
                alert1.setMessage(getText(R.string.alert_undead))
                alert1.setTitle(getText(R.string.alert_undead_title))
                alert1.setIcon(ContextCompat.getDrawable(this@Activity2, R.drawable.undead_png))
                alert1.setNeutralButton(getText(R.string.alert_neutral_button), null)
                alert1.show()
                return true
            }
        })
    }
}