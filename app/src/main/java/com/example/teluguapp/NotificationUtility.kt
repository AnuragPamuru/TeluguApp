package com.example.teluguapp

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotificationUtility : BroadcastReceiver(){

    @Override
    override fun onReceive(p0: Context?, p1: Intent?) {

        val context = p0 as Context
        val intent = Intent(p0, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        //build notification
        val builder = NotificationCompat.Builder(context, "com.example.teluguapp")
            .setSmallIcon(R.drawable.ic_small_icon)
            .setContentTitle("Jasmine")
            .setContentText("Come for a lesson!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        with(NotificationManagerCompat.from(context)) {
            // notificationId is a unique int for each notification that you must define
            notify(0, builder.build())
        }
    }
}