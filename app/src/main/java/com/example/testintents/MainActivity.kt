package com.example.testintents

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
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
            val bundle = Bundle()
            bundle.putParcelable(PARCELABLE_MESSAGE, CustomMessage("custom message"))
            intent.putExtras(bundle)
            //intent.putExtra(MESSAGE_TO_SECOND_ACTIVITY, "Message from first activity")
            startActivity(intent)
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
        const val PARCELABLE_MESSAGE = "ParcelableMessage"
    }
}

class CustomMessage (val message:String?):Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(message)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CustomMessage> {
        override fun createFromParcel(parcel: Parcel): CustomMessage {
            return CustomMessage(parcel)
        }

        override fun newArray(size: Int): Array<CustomMessage?> {
            return arrayOfNulls(size)
        }
    }
}