package juliano.correa.final_project

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStory.setOnClickListener {startActivity(Intent(this@MainActivity, Activity1::class.java))}
        buttonRaces.setOnClickListener {startActivity(Intent(this@MainActivity, Activity2::class.java))}
        buttonRules.setOnClickListener {startActivity(Intent(this@MainActivity, Activity3::class.java))}
        buttonRegister.setOnClickListener {startActivity(Intent(this@MainActivity, Activity4::class.java))}
        buttonSpringAdventure.setOnClickListener {play(R.raw.curyrip)}

    }

    private fun play(sound: Int) {
        mediaPlayer = MediaPlayer.create(this@MainActivity, sound)
        mediaPlayer.start()
    }

    private fun stop() {
        if(mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
    }
}