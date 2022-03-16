package com.example.android_12_splash_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    var isUserLoggedIn = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashActivity = installSplashScreen()
        setContentView(R.layout.activity_main)

        /**
         * setKeepOnScreenCondition pass true
         *
         */
        splashActivity.setKeepOnScreenCondition { true }
        if (isUserLoggedIn) {
            startActivity(Intent(StartActivity@ this, LoginActivity::class.java))
            finish()
        } else {
            startActivity(Intent(StartActivity@ this, DashboardActivity::class.java))
            finish()
        }
    }
}