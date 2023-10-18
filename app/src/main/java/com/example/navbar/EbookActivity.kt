package com.example.navbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class EbookActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ebook)

        val bukusaintek: TextView = findViewById(R.id.buku_sainteksma)
        bukusaintek.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.buku_sainteksma -> {
                    val intent = Intent(this@EbookActivity, BukuSaintekActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}