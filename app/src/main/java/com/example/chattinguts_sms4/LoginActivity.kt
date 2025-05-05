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
        setContentView(R.layout.activity_login)

        val usernameInput = findViewById<EditText>(R.id.username)
        val passwordInput = findViewById<TextInputEditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val registerButton = findViewById<Button>(R.id.registerButton)

        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

       loginButton.setOnClickListener {
          val  username =  usernameInput.text.toString().trim()
          val  password =  passwordInput.text.toString().trim()

           if(username.isNotEmpty() && password.isNotEmpty()){
                val userMatch = UserDatabase.users.find{ it.username == username && it.password == password}

               if(userMatch != null){
                  val intent = Intent(this, MainActivity::class.java)
                   intent.putExtra("Username_login" , username)
                   startActivity(intent)
                   finish()
               } else {
                   Toast.makeText(this, "Username Atau Password Salah" , Toast.LENGTH_SHORT).show()
               }
           } else {
               Toast.makeText(this, "Username dan Password Harus Diisi!" , Toast.LENGTH_SHORT).show()
           }
       }

    }
}