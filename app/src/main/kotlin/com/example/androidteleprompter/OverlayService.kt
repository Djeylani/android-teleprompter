package com.example.androidteleprompter

import android.app.Service
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Build
import android.os.IBinder
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.SeekBar
import android.provider.MediaStore

class OverlayService : Service() {

    private lateinit var windowManager: WindowManager
    private lateinit var overlayView: View
    private lateinit var teleprompterView: TeleprompterView
    private lateinit var speedControl: SeekBar
    private lateinit var closeButton: Button

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        
        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager
        
        overlayView = LayoutInflater.from(this).inflate(R.layout.view_teleprompter, null)
        overlayView.setBackgroundColor(0x66000000.toInt()) // More transparent background
        
        val layoutType = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        } else {
            WindowManager.LayoutParams.TYPE_PHONE
        }
        
        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.MATCH_PARENT,
            800, // Smaller height - about 1/3 of screen
            layoutType,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or
            WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
            WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
            PixelFormat.TRANSLUCENT
        )
        
        params.gravity = Gravity.TOP or Gravity.START
        params.x = 0
        params.y = 0
        
        windowManager.addView(overlayView, params)
        
        setupViews()
    }
    
    private fun setupViews() {
        teleprompterView = overlayView.findViewById(R.id.teleprompterView)
        speedControl = overlayView.findViewById(R.id.speedControl)
        closeButton = overlayView.findViewById(R.id.closeButton)
        
        speedControl.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                teleprompterView.setScrollSpeed((progress + 1).toLong())
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        
        closeButton.setOnClickListener {
            stopSelf()
        }
    }
    
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val script = intent?.getStringExtra("script") ?: "No script provided"
        val speed = intent?.getIntExtra("speed", 50) ?: 50
        val textSize = intent?.getIntExtra("textSize", 22) ?: 22
        
        teleprompterView.setTextContent(script)
        teleprompterView.setScrollSpeed(speed.toLong())
        teleprompterView.setTextSize(textSize.toFloat())
        
        // Launch camera without custom output - let camera app handle saving
        val cameraIntent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        cameraIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(cameraIntent)
        
        // Start scrolling after camera launches
        teleprompterView.postDelayed({
            teleprompterView.startScrolling()
        }, 2000)
        
        return START_STICKY
    }
    
    override fun onDestroy() {
        super.onDestroy()
        teleprompterView.stopScrolling()
        windowManager.removeView(overlayView)
    }
}