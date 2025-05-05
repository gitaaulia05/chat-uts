package com.example.chattinguts_sms4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val username = findViewById<TextView>(R.id.usernameLogin)
        val logout = findViewById<Button>(R.id.logoutButton)

        val loginUser = intent.getStringExtra("Username_login")

       if(!loginUser.isNullOrEmpty()) {
            username.text = loginUser
       } else{
           val intent = Intent(this, LoginActivity::class.java)
           startActivity(intent)
           finish()
       }

        logout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}