package com.example.navbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class GroupActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)

        val btnlihatsemua: Button = findViewById(R.id.button_lihatsemua)
        btnlihatsemua.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.button_lihatsemua -> {
                    val intent = Intent(this@GroupActivity, IsisChatDzikriActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}