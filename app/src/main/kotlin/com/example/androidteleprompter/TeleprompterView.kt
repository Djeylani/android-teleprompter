package com.example.androidteleprompter

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ScrollView
import android.widget.TextView
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.widget.LinearLayout
import android.view.MotionEvent

class TeleprompterView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ScrollView(context, attrs) {

    private var scrollSpeed: Long = 50
    private var isScrollingActive: Boolean = false
    private val handler = Handler(Looper.getMainLooper())
    private var scrollRunnable: Runnable? = null
    private val textView: TextView

    init {
        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
        
        // Remove spacer since we want text to start from top in half-screen overlay
        
        textView = TextView(context)
        textView.textSize = 22f
        textView.setTextColor(0xFFFFFFFF.toInt())
        textView.gravity = Gravity.CENTER_HORIZONTAL
        textView.setPadding(20, 12, 20, 12)
        textView.setShadowLayer(3f, 1f, 1f, 0xFF000000.toInt())
        textView.setBackgroundColor(0xBB000000.toInt())
        textView.alpha = 0.95f
        
        layout.addView(textView)
        addView(layout)
        
        setBackgroundColor(0x00000000) // Fully transparent
        
        // Enable touch events
        setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                if (isScrollingActive) {
                    stopScrolling()
                } else {
                    startScrolling()
                }
                true
            } else {
                false
            }
        }
    }

    fun startScrolling() {
        if (!isScrollingActive) {
            isScrollingActive = true
            scrollRunnable = object : Runnable {
                override fun run() {
                    if (isScrollingActive) {
                        smoothScrollBy(0, 2) // Positive for downward scroll
                        handler.postDelayed(this, scrollSpeed)
                    }
                }
            }
            handler.post(scrollRunnable!!)
        }
    }

    fun stopScrolling() {
        if (isScrollingActive) {
            isScrollingActive = false
            scrollRunnable?.let { 
                handler.removeCallbacks(it)
                scrollRunnable = null
            }
        }
    }

    fun isScrolling(): Boolean = isScrollingActive

    fun setScrollSpeed(speed: Long) {
        scrollSpeed = maxOf(1, 101 - speed) // Ensure minimum speed of 1
    }
    
    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        stopScrolling()
    }

    fun setTextContent(text: String) {
        textView.text = text
    }
}