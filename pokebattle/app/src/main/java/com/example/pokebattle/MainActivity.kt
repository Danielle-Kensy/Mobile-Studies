package com.example.pokebattle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var buttonAlerttutuga : Button
    private lateinit var buttonAlerttutugatwo : Button
    private lateinit var buttonAlerttutugathree : Button
    private lateinit var buttonAlertbulba : Button
    private lateinit var buttonAlertbulbatwo : Button
    private lateinit var buttonAlertbulbathree : Button
    private lateinit var buttonAlertdragon : Button
    private lateinit var buttonAlertdragontwo : Button
    private lateinit var buttonAlertdragonthree : Button
    private lateinit var buttonToasttutuga: Button
    private lateinit var buttonToasttutugatwo: Button
    private lateinit var buttonToasttutugathree: Button
    private lateinit var buttonToastbulba: Button
    private lateinit var buttonToastbulbatwo: Button
    private lateinit var buttonToastbulbathree: Button
    private lateinit var buttonToastdragon: Button
    private lateinit var buttonToastdragontwo: Button
    private lateinit var buttonToastdragonthree: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAlerttutuga = findViewById(R.id.button_tutuga)
        buttonAlerttutugatwo = findViewById(R.id.button_tutugatwo)
        buttonAlerttutugathree = findViewById(R.id.button_tutugathree)
        buttonAlertbulba = findViewById(R.id.button_bulba)
        buttonAlertbulbatwo = findViewById(R.id.button_bulbatwo)
        buttonAlertbulbathree = findViewById(R.id.button_bulbathree)
        buttonAlertdragon = findViewById(R.id.button_dragon)
        buttonAlertdragontwo = findViewById(R.id.button_dragontwo)
        buttonAlertdragonthree = findViewById(R.id.button_dragonthree)
        buttonToasttutuga = findViewById(R.id.button_tutuga)
        buttonToasttutugatwo = findViewById(R.id.button_tutugatwo)
        buttonToasttutugathree = findViewById(R.id.button_tutugathree)
        buttonToastbulba = findViewById(R.id.button_bulba)
        buttonToastbulbatwo = findViewById(R.id.button_bulbatwo)
        buttonToastbulbathree = findViewById(R.id.button_bulbathree)
        buttonToastdragon = findViewById(R.id.button_dragon)
        buttonToastdragontwo = findViewById(R.id.button_dragontwo)
        buttonToastdragonthree = findViewById(R.id.button_dragonthree)

        buttonToasttutuga.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(this@MainActivity, getText(R.string.tutuga), Toast.LENGTH_LONG).show()
            }
        })

        buttonToasttutugatwo.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(this@MainActivity, getText(R.string.tutugatwo), Toast.LENGTH_LONG).show()
            }
        })

        buttonToasttutugathree.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(this@MainActivity, getText(R.string.tutugathree), Toast.LENGTH_LONG).show()
            }
        })

        buttonToastbulba.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(this@MainActivity, getText(R.string.bulba), Toast.LENGTH_LONG).show()
            }
        })

        buttonToastbulbatwo.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(this@MainActivity, getText(R.string.bulbatwo), Toast.LENGTH_LONG).show()
            }
        })

        buttonToastbulbathree.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(this@MainActivity, getText(R.string.bulbathree), Toast.LENGTH_LONG).show()
            }
        })

        buttonToastdragon.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(this@MainActivity, getText(R.string.dragon), Toast.LENGTH_LONG).show()
            }
        })

        buttonToastdragontwo.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(this@MainActivity, getText(R.string.dragontwo), Toast.LENGTH_LONG).show()
            }
        })

        buttonToastdragonthree.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(this@MainActivity, getText(R.string.dragonthree), Toast.LENGTH_LONG).show()
            }
        })

        buttonAlerttutuga.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                var alert1 = AlertDialog.Builder(this@MainActivity)
                alert1.setMessage(getText(R.string.alert_tutuga))
                alert1.setTitle(getText(R.string.alert_title_tutuga))
                alert1.setIcon(ContextCompat.getDrawable(this@MainActivity, R.drawable.tutugaone))
                alert1.setNeutralButton(getText(R.string.neutral_button), null)
                alert1.show()
                return true
            }
        })

        buttonAlerttutugatwo.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                var alert1 = AlertDialog.Builder(this@MainActivity)
                alert1.setMessage(getText(R.string.alert_tutugatwo))
                alert1.setTitle(getText(R.string.alert_title_tutugatwo))
                alert1.setIcon(ContextCompat.getDrawable(this@MainActivity, R.drawable.tutugatwo))
                alert1.setNeutralButton(getText(R.string.neutral_button), null)
                alert1.show()
                return true
            }
        })

        buttonAlerttutugathree.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                var alert1 = AlertDialog.Builder(this@MainActivity)
                alert1.setMessage(getText(R.string.alert_tutugathree))
                alert1.setTitle(getText(R.string.alert_title_tutugathree))
                alert1.setIcon(ContextCompat.getDrawable(this@MainActivity, R.drawable.tutugathree))
                alert1.setNeutralButton(getText(R.string.neutral_button), null)
                alert1.show()
                return true
            }
        })

        buttonAlertbulba.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                var alert1 = AlertDialog.Builder(this@MainActivity)
                alert1.setMessage(getText(R.string.alert_bulba))
                alert1.setTitle(getText(R.string.alert_title_bulba))
                alert1.setIcon(ContextCompat.getDrawable(this@MainActivity, R.drawable.bubaone))
                alert1.setNeutralButton(getText(R.string.neutral_button), null)
                alert1.show()
                return true
            }
        })

        buttonAlertbulbatwo.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                var alert1 = AlertDialog.Builder(this@MainActivity)
                alert1.setMessage(getText(R.string.alert_bulbatwo))
                alert1.setTitle(getText(R.string.alert_title_bulbatwo))
                alert1.setIcon(ContextCompat.getDrawable(this@MainActivity, R.drawable.bubatwo))
                alert1.setNeutralButton(getText(R.string.neutral_button), null)
                alert1.show()
                return true
            }
        })

        buttonAlertbulbathree.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                var alert1 = AlertDialog.Builder(this@MainActivity)
                alert1.setMessage(getText(R.string.alert_bulbathree))
                alert1.setTitle(getText(R.string.alert_title_bulbathree))
                alert1.setIcon(ContextCompat.getDrawable(this@MainActivity, R.drawable.bubathree))
                alert1.setNeutralButton(getText(R.string.neutral_button), null)
                alert1.show()
                return true
            }
        })

        buttonAlertdragon.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                var alert1 = AlertDialog.Builder(this@MainActivity)
                alert1.setMessage(getText(R.string.alert_dragon))
                alert1.setTitle(getText(R.string.alert_title_dragon))
                alert1.setIcon(ContextCompat.getDrawable(this@MainActivity, R.drawable.darone))
                alert1.setNeutralButton(getText(R.string.neutral_button), null)
                alert1.show()
                return true
            }
        })

        buttonAlertdragontwo.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                var alert1 = AlertDialog.Builder(this@MainActivity)
                alert1.setMessage(getText(R.string.alert_dragontwo))
                alert1.setTitle(getText(R.string.alert_title_dragontwo))
                alert1.setIcon(ContextCompat.getDrawable(this@MainActivity, R.drawable.dratwo))
                alert1.setNeutralButton(getText(R.string.neutral_button), null)
                alert1.show()
                return true
            }
        })

        buttonAlertdragonthree.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                var alert1 = AlertDialog.Builder(this@MainActivity)
                alert1.setMessage(getText(R.string.alert_dragonthree))
                alert1.setTitle(getText(R.string.alert_title_dragonthree))
                alert1.setIcon(ContextCompat.getDrawable(this@MainActivity, R.drawable.drathree))
                alert1.setNeutralButton(getText(R.string.neutral_button), null)
                alert1.show()
                return true
            }
        })
    }
}