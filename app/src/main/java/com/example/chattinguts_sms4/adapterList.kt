package com.example.chattinguts_sms4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import kotlin.random.Random

class adapterList(private val context: Context, private val data: List<messageSystem> ): BaseAdapter() {

    // fungsi ini mmeberikan jumlah item yang akan tampil dalam list
    override fun getCount(): Int = data.size

    // fungsi ini  mengembalikan data pada posisi tertentu.
    override fun getItem(position: Int): Any = data[position]

    // fungsi ini mengembalikan id unik dari setiap item.
    override fun getItemId(position: Int): Long = position.toLong()

    // fungsi ini menampilkan tampilan tiap item
    override fun getView(position: Int, convertView: View?, parent:ViewGroup?): View{

        val view : View = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        // var item akan mengambil data dari dataMessage di posisi POSITION
        // untuk ditampilkan pada list item.
        val item = data[position]

        // ambil id dari komponen tampilan dari layout list_item.xml
        val fromText = view.findViewById<TextView>(R.id.fromTextView)
        val messageText = view.findViewById<TextView>(R.id.messageTextView)
        val timeText = view.findViewById<TextView>(R.id.timeTextView)
        val imageView = view.findViewById<CircleImageView>(R.id.profileImage)


        // isi nilai elemen dengan data dari dataMessage.
        fromText.text = item.from
        messageText.text = item.message
        timeText.text = item.time

        // Mendeklarasikan tipe array dan mengisinya dengan nilai image yang ada di drawable
        val profileImages: Array<Int> = arrayOf(R.drawable.profile, R.drawable.profile2, R.drawable.profile3)

        // pilih gambar secara acak menggunakan random.nextInt
        val randomImage = profileImages[Random.nextInt(profileImages.size)]

        //ambil nilai dari random image render ke image view di list item.
        imageView.setImageResource(randomImage)

        return view
    }
}