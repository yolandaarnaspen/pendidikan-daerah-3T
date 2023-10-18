package com.example.navbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ChatActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val btnmulai: Button = findViewById(R.id.button_mulai)
        btnmulai.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.button_mulai -> {
                    val intent = Intent(this@ChatActivity, GroupActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}