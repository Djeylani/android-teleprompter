package com.example.androidteleprompter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var scriptEditText: EditText
    private lateinit var startButton: Button
    private lateinit var saveScriptButton: Button
    private lateinit var loadScriptButton: Button
    private lateinit var speedSeekBar: SeekBar
    private lateinit var textSizeSeekBar: SeekBar
    private lateinit var scriptManager: ScriptManager
    private var scrollSpeed = 50
    private var textSize = 22

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scriptManager = ScriptManager(this)
        
        scriptEditText = findViewById(R.id.scriptEditText)
        startButton = findViewById(R.id.startTeleprompterButton)
        saveScriptButton = findViewById(R.id.saveScriptButton)
        loadScriptButton = findViewById(R.id.loadScriptButton)
        speedSeekBar = findViewById(R.id.speedSeekBar)
        textSizeSeekBar = findViewById(R.id.textSizeSeekBar)
        
        loadSavedData()

        speedSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                scrollSpeed = progress + 1
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        
        textSizeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textSize = progress + 16 // Range: 16-48sp
                scriptEditText.textSize = textSize.toFloat()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Load saved script or set default
        val savedScript = scriptManager.getCurrentScript()
        if (savedScript.isNotEmpty()) {
            scriptEditText.setText(savedScript)
        } else {
            scriptEditText.setText(getString(R.string.default_script))
        }

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
                intent.putExtra("textSize", textSize)
                startActivity(intent)
            } catch (e: Exception) {
                Log.e("MainActivity", "Error starting teleprompter", e)
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
        
        saveScriptButton.setOnClickListener {
            showSaveScriptDialog()
        }
        
        loadScriptButton.setOnClickListener {
            showLoadScriptDialog()
        }
    }
    
    private fun loadSavedData() {
        scrollSpeed = scriptManager.getLastSpeed()
        speedSeekBar.progress = scrollSpeed - 1
        
        textSize = scriptManager.getTextSize()
        textSizeSeekBar.progress = textSize - 16
        scriptEditText.textSize = textSize.toFloat()
    }
    
    override fun onPause() {
        super.onPause()
        saveCurrentData()
    }
    
    private fun saveCurrentData() {
        val currentScript = scriptEditText.text.toString()
        scriptManager.saveCurrentScript(currentScript)
        scriptManager.saveLastSpeed(scrollSpeed)
        scriptManager.saveTextSize(textSize)
    }
    
    private fun showSaveScriptDialog() {
        val input = EditText(this)
        input.hint = "Enter script name"
        
        AlertDialog.Builder(this)
            .setTitle("Save Script")
            .setView(input)
            .setPositiveButton("Save") { _, _ ->
                val name = input.text.toString().trim()
                if (name.isNotEmpty()) {
                    val script = scriptEditText.text.toString()
                    scriptManager.saveScript(name, script)
                    Toast.makeText(this, "Script '$name' saved", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
    
    private fun showLoadScriptDialog() {
        val savedScripts = scriptManager.getSavedScriptNames().toList()
        
        if (savedScripts.isEmpty()) {
            Toast.makeText(this, "No saved scripts", Toast.LENGTH_SHORT).show()
            return
        }
        
        AlertDialog.Builder(this)
            .setTitle("Load Script")
            .setItems(savedScripts.toTypedArray()) { _, which ->
                val scriptName = savedScripts[which]
                val script = scriptManager.loadScript(scriptName)
                scriptEditText.setText(script)
                Toast.makeText(this, "Script '$scriptName' loaded", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}