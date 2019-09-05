package com.comomesiento

import android.Manifest
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.title = "¡Hola!"

        // asking permission to access file system
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),43)

        // we need to go trough all the 18 animal buttons and set what happens when they are clicked
        for (i in 0..17) {
            // the buttons are named "ib0" .. "ib17", short for 'imagebutton0' ...
            val id = resources.getIdentifier("ib$i", "id", packageName)
            val button = findViewById<ImageButton>(id)

            // define what happens after a click
            button.setOnClickListener {
                // an "Intent" is like a request to open a new screen
                val intent = Intent(this, ChooseEmotionActivity::class.java)
                // when opening the new screen, we need to remember the animal that the user selected
                // so, we put the clicked button's tag variable into the new activity "extra" space
                // (we will read this "user" variable from the other screen
                intent.putExtra("user",  button.tag.toString())
                // and then start the activity (activity = new screen)
                startActivity(intent)
            }
        }

    }

}
