package com.example.testintents

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val message: TextView = findViewById(R.id.title)
        intent?.let {
            var messageFromBundle = ""
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                messageFromBundle =
                    it.getParcelableExtra(MainActivity.PARCELABLE_MESSAGE, CustomMessage::class.java).toString()
            } else {
                messageFromBundle = it.getParcelableExtra<CustomMessage>(MainActivity.PARCELABLE_MESSAGE)
                    ?.message.toString()
            }
            message.text = messageFromBundle
        }


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


