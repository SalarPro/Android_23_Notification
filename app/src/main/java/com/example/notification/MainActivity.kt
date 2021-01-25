package com.example.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "myTagMyApp"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createChannel()

        btn1.setOnClickListener {
            ShowNoti("sport1")
            ShowNoti("3")
        }

    }
    var notID = 0

    fun ShowNoti(channelID : String){
        notID++
        val mIntent = Intent(this, MainActivity2::class.java)
                .putExtra("isFromNotification",true)

        val pendingIntent = PendingIntent.getActivity(this,123,mIntent,0)

        val sounURI = Uri.parse("android.resource://"+ packageName + "/" + R.raw.nokia_ringtone)

        val notification = NotificationCompat.Builder(this, channelID)
                .setContentTitle("My First Notification $channelID")
                .setContentText("This is my First notification With Salar Pro")
                .setSmallIcon(R.drawable.sun)
                .setColor(Color.RED)
                .setSound(sounURI)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.img1))
                .setContentIntent(pendingIntent)

        with(NotificationManagerCompat.from(this)) {
            notify(notID, notification.build())
        }

    }

    fun createChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel("3", "Sport News1", NotificationManager.IMPORTANCE_DEFAULT)

            val sounURI = Uri.parse("android.resource://"+ packageName + "/" + R.raw.nokia_ringtone)

            val audioAttribute = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build()

            channel.setSound(sounURI,audioAttribute)

            val notifaManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notifaManager.createNotificationChannel(channel)

            Log.d(TAG,"Notification Channel created")

        }

    }
    fun createChannel2() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel("2", "news", NotificationManager.IMPORTANCE_DEFAULT)

            val notifaManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notifaManager.createNotificationChannel(channel)

            Log.d(TAG,"Notification Channel created")

        }

    }

    fun btn222(view: View) {
       startActivity(Intent(this, MainActivity2::class.java))

    }

}