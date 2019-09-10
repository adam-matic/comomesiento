package com.comomesiento

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import android.widget.LinearLayout
import android.support.v4.app.SupportActivity
import android.support.v4.app.SupportActivity.ExtraData
import android.support.v4.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.Menu
import android.view.MenuItem


class ChooseEmotionActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val subMenu = menu.addSubMenu(0, Menu.NONE, 0, "www.freepik.com")
        subMenu.item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_emotion)
        this.title ="¿Cómo me siento?"

        // get the user code from the "intent extra"
        val user = this.intent.getStringExtra("user")

        // for every button, define what happens after clicking
        for (i in 1..12) {

            // get button 'address', they are named as "ibe1' 'ibe2' .., as short for "imagebutton1" ..
            val id = resources.getIdentifier("ibe$i", "id", packageName)
            val button = findViewById<ImageButton>(id)

            // this one sets the event after clicking
            button.setOnClickListener {

                val date = SimpleDateFormat( "dd.MM.yyyy").format(Date())
                val timeofday = SimpleDateFormat("HH.mm.ss").format(Date())
                val emotion = button.tag.toString()
                val text = "$timeofday $user is $emotion\n"  // this will be something like "b is e1"
                val filename = "Como me siento $date.txt"
                val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

                // if the directory does not exist, make it
                path.mkdirs()

                // write text to file
                File(path, filename).appendText(text)

                var t = Toast.makeText(this,  "¡Gracias!", Toast.LENGTH_LONG)
                ((t.getView() as LinearLayout).getChildAt(0) as TextView).textSize = 30f
                t.show()

                super.finish()
            }
        }
    }

}
