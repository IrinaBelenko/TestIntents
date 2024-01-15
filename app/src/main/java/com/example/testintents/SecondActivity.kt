package com.example.testintents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val message: TextView = findViewById(R.id.title)
        intent?.let { message.text =
            it.getStringExtra(MainActivity.MESSAGE_TO_SECOND_ACTIVITY) }
    }
}