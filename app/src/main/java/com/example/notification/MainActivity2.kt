package com.example.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        if (intent.getBooleanExtra("isFromNotification",false)){
            Toast.makeText(this,"Yes it is from notification",Toast.LENGTH_LONG).show()
        }

    }
}