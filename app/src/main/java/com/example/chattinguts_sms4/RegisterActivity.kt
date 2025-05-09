package com.example.chattinguts_sms4

import android.R.attr.text
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // kode ini berelasi dengan layout activity_register
        setContentView(R.layout.activity_register)

        // ambil id dari komponen tampilan dari layout activity_register
        val usernameInput = findViewById<EditText>(R.id.username)
        val passwordInput = findViewById<TextInputEditText>(R.id.password)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val loginButton = findViewById<Button>(R.id.loginButton)

        // aksi yang akan dijalankan ketika mengklik loginButton
        loginButton.setOnClickListener {
            // intent ini akan mengarahkan ke halaman LoginActivity yang dimana berelasi dengan activity_login.
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // pada saat registerButton Di klik akan menjalankan kondisi dibawah ini
        registerButton.setOnClickListener {
            // ambil inputan dari user dan hapus spasi di awal atau akhir
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            // kondisi ini akan mengecek apakah username dan password tidak kosong
            if (username.isNotEmpty() && password.isNotEmpty()) {
                // ini akan mengecek di data class userDatabase apakah ada username yang diinputkan user
                val isUsernameTaken = UserDatabase.users.any { it.username == username }

                // jika username tidak ada ( artinya unik belum tersimpan di data class )
                if (!isUsernameTaken) {
                    // maka akan langsung disimpan di data class User Database
                    val newUser = User(username, password)
                    UserDatabase.users.add(newUser)

                    // selanjutnya redirect ke halaman loginActivity
                    val intent = Intent(this, LoginActivity::class.java)
                    // logcat
                    Log.d("RegisterActivity" , "username Diterima : $username")
                    startActivity(intent)
                    finish()
                }
                // jika username sudah ada di data class akan menjalankan kondisi ini
                else {
                    // toast dan logcat.
                    Toast.makeText(this, "Username sudah Terdaftar", Toast.LENGTH_SHORT).show()
                    Log.w("RegisterActivity" , "Username Sudah Terdaftar : $username")
                }
            }
            // jika user name dan password kosong akan menjalankan kondisi dibawah
            else{
                // menjalankan toast dan logcat.
                Log.e("RegisterActivity" , "Username dan Password Kosong!")
                Toast.makeText(this, "Username dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}