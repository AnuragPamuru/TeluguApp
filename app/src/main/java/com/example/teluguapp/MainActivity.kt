package com.example.teluguapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    lateinit var mFrame: FrameLayout
    lateinit var mNavBar: BottomNavigationView
    lateinit var settingsScreen: SettingsFragment
    lateinit var homeScreen: HomeFragment
    lateinit var searchScreen: SearchFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()

        //set notification intent
        val intent = Intent(applicationContext, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        //build notification
        var builder = NotificationCompat.Builder(this, "com.example.teluguapp")
            .setSmallIcon(R.drawable.ic_small_icon)
            .setContentTitle("Jasmine")
            .setContentText("Come for a lesson!")
            .setColor(resources.getColor(R.color.colorPrimary))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(0, builder.build())
        }


        //initialize the navigation bar
        mFrame = findViewById<FrameLayout>(R.id.main_frame)
        mNavBar = findViewById<BottomNavigationView>(R.id.main_nav)

        settingsScreen = SettingsFragment()
        homeScreen = HomeFragment()
        searchScreen = SearchFragment()

        mNavBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home_menu_item -> {
                return@OnNavigationItemSelectedListener true
                openFragment(homeScreen)
            }
            R.id.settings_menu_item -> {
                return@OnNavigationItemSelectedListener true
                openFragment(settingsScreen)
            }
            R.id.search_menu_item -> {
                return@OnNavigationItemSelectedListener true
                openFragment(searchScreen)
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("com.example.teluguapp", name, importance).apply {
                description = descriptionText
            }

            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

            //set channel settings
            channel.enableLights(true)
            channel.lightColor = Color.GREEN
            channel.enableVibration(true)
        }
    }
}
