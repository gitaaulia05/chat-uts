package com.example.chattinguts_sms4

object UserDatabase {
    val users = mutableListOf<User>()
}
data class User(val username: String, val password: String)
