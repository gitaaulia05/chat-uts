package com.example.chattinguts_sms4

object dataMessage{
    val message = mutableListOf<messageSystem>()

}
data class messageSystem(val from: String , val message: String, val time: String)