package com.example.chattinguts_sms4

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        // HANDLER UNTUNK MENJEDA RUNNING FUNGSI goToMainActivity Selama 3 detik
        Handler(Looper.getMainLooper()).postDelayed({
            goToMainActivity()

        }, 3000L)

    }


    // FUNGSI INI UNTUK MENAMPILKAN HALAMAN UTAMA
    private fun goToMainActivity() {
    Intent(this, MainActivity::class.java).also{
        startActivity(it)
        finish();
    }
    }
}