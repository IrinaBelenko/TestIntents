package com.example.testintents

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            // 1
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
            //2
//            val url = Uri.parse("https://google.com")
//            val actionIntent = Intent(Intent.ACTION_VIEW, url)
//            startActivity(actionIntent)
            //3
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("SecondActivityMessage", "Message from first activity")
            startActivity(intent)
        }
    }

    companion object{
        const val MESSAGE_TO_SECOND_ACTIVITY = "SecondActivityMessage"
    }
}