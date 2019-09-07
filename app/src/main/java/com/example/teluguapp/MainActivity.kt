package com.example.teluguapp

import android.app.AlarmManager
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
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MainActivity : AppCompatActivity() {


    private lateinit var mFrame: FrameLayout
    private lateinit var mNavBar: BottomNavigationView
    private lateinit var settingsScreen: SettingsFragment
    private lateinit var homeScreen: HomeFragment
    private lateinit var searchScreen: SearchFragment

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //notification setup
        createNotificationChannel()
        buildNotificationReminder()

        //initialize the navigation bar
        mFrame = findViewById(R.id.main_frame)
        mNavBar = findViewById(R.id.main_nav)

        settingsScreen = SettingsFragment()
        homeScreen = HomeFragment()
        searchScreen = SearchFragment()

        mNavBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        openFragment(homeScreen)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when (item.itemId) {
            R.id.home_menu_item -> {
                //add homeScreen
                openFragment(homeScreen)
                return@OnNavigationItemSelectedListener true
            }
            R.id.settings_menu_item -> {
                //add settingsScreen
                openFragment(settingsScreen)
                return@OnNavigationItemSelectedListener true
            }
            R.id.search_menu_item -> {
                //add searchScreen
                openFragment(searchScreen)
                return@OnNavigationItemSelectedListener true
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

    private fun buildNotificationReminder(){
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, calendar.)
        calendar.set(Calendar.MINUTE,47)

        val intent = Intent(this, NotificationReceiver::class.java)

        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, AlarmManager.INTERVAL_DAY, pendingIntent)
    }
}