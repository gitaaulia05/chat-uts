package com.example.chattinguts_sms4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // kode logika ini berelasi dengan layout activity_login
        setContentView(R.layout.activity_login)

        // ambil id dari komponen tampilan dari layout activity_login
        val usernameInput = findViewById<TextInputEditText>(R.id.username)
        val passwordInput = findViewById<TextInputEditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val registerButton = findViewById<Button>(R.id.registerButton)

        // aksi yang akan dijalankan ketika mengklik RegisterButton
        registerButton.setOnClickListener {
            // intent ini akan mengarahkan ke halaman registerActivity.
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        // aksi yang akan dijalankan ketika mengklik loginButton.
       loginButton.setOnClickListener {
           // ambil inputan dari user dan hapus spasi di awal atau akhir
          val  username =  usernameInput.text.toString().trim()
          val  password =  passwordInput.text.toString().trim()

           // kondisi ini akan mengecek apakah username dan password tdidak kosong
           if(username.isNotEmpty() && password.isNotEmpty()){
               // ini akan mengecek data di data class userDatabase apakah ada username dan password yang di inputkan user.
                val userMatch = UserDatabase.users.find{ it.username == username && it.password == password}

               // jika Variable userMatch ini terisi maka data ditemukan
               if(userMatch != null){
                   // akan redirect ke halaman mainActivity
                  val intent = Intent(this, MainActivity::class.java)
                   // dengan menyisipkan username ke intent dengan key Username_login.
                   intent.putExtra("Username_login" , username)
                   startActivity(intent)
                   finish()
               }
               // jika password dan username tidak terdaftar akan memunculkan toast.
               else {
                   Toast.makeText(this, "Username Atau Password Salah" , Toast.LENGTH_SHORT).show()
               }
           }
           // jika password dan username kosong memunculkan toast peringatan.
           else {
               Toast.makeText(this, "Username dan Password Harus Diisi!" , Toast.LENGTH_SHORT).show()
           }
       }

    }
}