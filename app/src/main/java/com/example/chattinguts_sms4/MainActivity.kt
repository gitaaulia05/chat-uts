package com.example.chattinguts_sms4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
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
        // kode logika ini berelasi dengan layout activity_main
        setContentView(R.layout.activity_main)

        // ambil id dari komponen tampilan dari layout activity_main
        val username = findViewById<TextView>(R.id.usernameLogin)
        val logout = findViewById<Button>(R.id.logoutButton)
        val listView = findViewById<ListView>(R.id.listView)

        // ambil sisipan username yang tadi telah dibuat dengan key Username_Login
        val loginUser = intent.getStringExtra("Username_login")

        //jika variabel loginUser ini tidak kosong maka akan menjalankan kode dibawah ini
       if(!loginUser.isNullOrEmpty()) {
           // mengisi variabel username dengan loginUser.
            username.text = loginUser

           //menambahkan data kedalam list dataMessage.message
           dataMessage.message.add(messageSystem("Camilla" , "hello" , "8.34"))
           dataMessage.message.add(messageSystem("Becky" , "hello Whatsup" , "8.00"))
           dataMessage.message.add(messageSystem("Natti" , "dare you" , "6.00"))

           // menghubungkan adapter ke listview agar data muncul di halaman.
           val adapter = adapterList(this, dataMessage.message)
           listView.adapter = adapter
       }
       // jika variable loginUser kosong maka akan redirect ke halaman
       // loginActivity.
       else{
           val intent = Intent(this, LoginActivity::class.java)
           startActivity(intent)
           finish()
       }

        // aksi yang akan terjadi jika mengklik button logout
        logout.setOnClickListener {
            // redirect ke halaman loginActivity.
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}