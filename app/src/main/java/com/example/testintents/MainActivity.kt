package com.example.testintents

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

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
            intent.putExtra(MESSAGE_TO_SECOND_ACTIVITY, "Message from first activity")
            startActivityForResult(intent,600)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {

        if (resultCode == RESULT_OK && requestCode == 600) {
            val message = intent?.getStringExtra(SecondActivity.MESSAGE_TO_FIRST_ACTIVITY)
            message?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object{
        const val MESSAGE_TO_SECOND_ACTIVITY = "SecondActivityMessage"
    }
}