package com.example.chattinguts_sms4

import android.R.attr.password
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import kotlin.jvm.java
import kotlin.math.log

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)


        val usernameInput = findViewById<EditText>(R.id.username)
        val passwordInput = findViewById<TextInputEditText>(R.id.password)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        registerButton.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                val isUsernameTaken = UserDatabase.users.any { it.username == username }

                if (!isUsernameTaken) {
                    val newUser = User(username, password)
                    UserDatabase.users.add(newUser)
                    val intent = Intent(this, LoginActivity::class.java)
                    Log.d("RegisterActivity" , "username Diterima : $username")
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Username sudah Terdaftar", Toast.LENGTH_SHORT).show()
                    Log.w("RegisterActivity" , "Username Sudah Terdaftar : $username")
                }
            }else {
                Toast.makeText(this, "Username dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                Log.e("RegisterActivity" , "Username dan Password Kosong!")

            }

        }
    }
}