package com.example.navbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class EquipperActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipper)

        val btnsoshum: Button = findViewById(R.id.button_Soshum)
        btnsoshum.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.button_Soshum -> {
                    val intent = Intent(this@EquipperActivity, SoshumActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}