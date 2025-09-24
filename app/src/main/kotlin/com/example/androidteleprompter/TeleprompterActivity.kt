package com.example.androidteleprompter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.os.Build
import android.net.Uri
import android.provider.Settings

class TeleprompterActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
            val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName"))
            startActivity(intent)
            Toast.makeText(this, "Please grant overlay permission and try again", Toast.LENGTH_LONG).show()
            finish()
            return
        }
        
        val script = intent.getStringExtra("script") ?: "No script provided"
        val speed = intent.getIntExtra("speed", 50)
        val textSize = intent.getIntExtra("textSize", 22)
        
        val serviceIntent = Intent(this, OverlayService::class.java)
        serviceIntent.putExtra("script", script)
        serviceIntent.putExtra("speed", speed)
        serviceIntent.putExtra("textSize", textSize)
        startService(serviceIntent)
        
        Toast.makeText(this, "Teleprompter overlay started", Toast.LENGTH_SHORT).show()
        finish()
    }
}