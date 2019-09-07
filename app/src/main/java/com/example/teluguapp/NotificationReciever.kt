package com.example.teluguapp

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotificationReceiver : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        val notificationManager = p0?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val repeatingIntent = Intent(p0, MainActivity::class.java)
        repeatingIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

        val pendingIntent = PendingIntent.getActivity(p0, 0, repeatingIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        //build notification
        val builder = NotificationCompat.Builder(p0, "com.example.teluguapp")
            .setSmallIcon(R.drawable.ic_small_icon)
            .setContentTitle("Come for a lesson!")
            .setContentText("Your next lesson is Vowels")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        with(NotificationManagerCompat.from(p0)) {
            // notificationId is a unique int for each notification that you must define
            notify(0, builder.build())
        }
    }

}