package com.example.androidteleprompter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var scriptEditText: EditText
    private lateinit var startButton: Button
    private lateinit var speedSeekBar: SeekBar
    private var scrollSpeed = 50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scriptEditText = findViewById(R.id.scriptEditText)
        startButton = findViewById(R.id.startTeleprompterButton)
        speedSeekBar = findViewById(R.id.speedSeekBar)

        speedSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                scrollSpeed = progress + 1
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Set default text
        scriptEditText.setText(getString(R.string.default_script))

        startButton.setOnClickListener {
            try {
                val script = scriptEditText.text.toString().trim()
                if (script.isEmpty()) {
                    Toast.makeText(this, "Please enter some text first", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                
                Log.d("MainActivity", "Starting teleprompter with speed: $scrollSpeed")
                val intent = Intent(this, TeleprompterActivity::class.java)
                intent.putExtra("script", script)
                intent.putExtra("speed", scrollSpeed)
                startActivity(intent)
            } catch (e: Exception) {
                Log.e("MainActivity", "Error starting teleprompter", e)
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}