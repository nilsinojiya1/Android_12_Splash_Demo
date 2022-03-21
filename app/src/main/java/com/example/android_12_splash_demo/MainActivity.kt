package com.example.android_12_splash_demo

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            Log.d("MainActivity", "onCreate: I AM RUNNING ON API 12 or higher")
            // custom exit on splashScreen

            splashActivity.setKeepOnScreenCondition {
                when(isUserLoggedIn){
                    true -> {startActivity(Intent(this, LoginActivity::class.java))
                        finish()
                    }
                    false ->{
                        startActivity(Intent(this, DashboardActivity::class.java))
                        finish()
                    }
                }
                true
            }


            /*splashScreen.setOnExitAnimationListener { splashScreenView ->
                // custom animation.
                ObjectAnimator.ofFloat(
                    splashScreenView,
                    View.TRANSLATION_X,
                    0f,
                    splashScreenView.width.toFloat()
                ).apply {
                    duration = 1000
                    // Call SplashScreenView.remove at the end of your custom animation.
                    doOnEnd {
                        splashScreenView.remove()
                    }
                }.also {
                    // Run your animation.
                    it.start()
                }

            }*/
        }
    }
}