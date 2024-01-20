package com.example.testintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val message: TextView = findViewById(R.id.title)
        intent?.let { message.text =
            it.getStringExtra(MainActivity.MESSAGE_TO_SECOND_ACTIVITY) }

        val sendBackButton:Button = findViewById(R.id.sendBackButton)
        sendBackButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra(MESSAGE_TO_FIRST_ACTIVITY,"Message From Second Activity")
            setResult(RESULT_OK, intent)
            finish()
        }

    }

    companion object {
        const val MESSAGE_TO_FIRST_ACTIVITY = "messageToFirstActivity"
    }
}