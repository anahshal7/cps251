package com.example.lifecycle

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Date

class LifeCycleText{
    companion object {
        var staticText: String = ""
    }
    fun updateDisplayText(updatedText: String){
        staticText += "\n" + updatedText

    }
    fun getDisplayText(): String {
        return staticText
    }
    @SuppressLint("SimpleDateFormat")
    fun getTimeString(): String{
        val stamp = System.currentTimeMillis()
        val sdf = SimpleDateFormat("HH:mm:ss.SSS")
        val date = Date(stamp)
        return sdf.format(date)
    }
}

class MainActivity : AppCompatActivity() {
    private val lifeCycleText = LifeCycleText()
    private var lastOrientation = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lifeCycleTextView = findViewById<TextView>(R.id.statusText)
        lastOrientation = this.resources.configuration.orientation
        lifeCycleText.updateDisplayText("onCreate was fired on "
                + lifeCycleText.getTimeString())
        lifeCycleTextView.text = lifeCycleText.getDisplayText()

    }

    override fun onStart() {
        super.onStart()
        val lifeCycleTextView = findViewById<TextView>(R.id.statusText)
        lifeCycleText.updateDisplayText("onStart was fired on "
                + lifeCycleText.getTimeString())
        lifeCycleTextView.text = lifeCycleText.getDisplayText()
    }

    override fun onResume() {
        super.onResume()
        val lifeCycleTextView = findViewById<TextView>(R.id.statusText)
        lifeCycleText.updateDisplayText("onResume was fired on "
                + lifeCycleText.getTimeString() + "\n*****")
        lifeCycleTextView.text = lifeCycleText.getDisplayText()
    }

    override fun onStop() {
        super.onStop()
        val lifeCycleTextView = findViewById<TextView>(R.id.statusText)
        lifeCycleText.updateDisplayText("onStop was fired on "
                + lifeCycleText.getTimeString())
        lifeCycleTextView.text = lifeCycleText.getDisplayText()
    }

    override fun onDestroy() {
        super.onDestroy()
        val lifeCycleTextView = findViewById<TextView>(R.id.statusText)
        lifeCycleText.updateDisplayText("onStop was fired on "
                + lifeCycleText.getTimeString() + "\n*****")
        lifeCycleTextView.text = lifeCycleText.getDisplayText()
    }

    override fun onPause() {
        super.onPause()
        val lifeCycleTextView = findViewById<TextView>(R.id.statusText)
        lifeCycleText.updateDisplayText("onPause was fired on "
                + lifeCycleText.getTimeString() + "\n*****")
        lifeCycleTextView.text = lifeCycleText.getDisplayText()
    }
}