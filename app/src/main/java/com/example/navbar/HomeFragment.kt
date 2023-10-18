package com.example.navbar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class HomeFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnequipper: Button = view.findViewById(R.id.button_quipper)
        btnequipper.setOnClickListener(this)

        val btnartikel: Button = view.findViewById(R.id.button_artikel)
        btnartikel.setOnClickListener(this)

        val btnebook: Button = view.findViewById(R.id.button_ebook)
        btnebook.setOnClickListener(this)

        val btnchat: Button = view.findViewById(R.id.button_chat)
        btnchat.setOnClickListener(this)

        val btnshare: Button = view.findViewById(R.id.button_share)
        btnshare.setOnClickListener(this)

        val btnnotif: Button = view.findViewById(R.id.button_notif)
        btnnotif.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.button_quipper){
            val intent = Intent(activity, EquipperActivity::class.java)
            startActivity(intent)
        }
        if (v?.id == R.id.button_artikel){
            val intent = Intent(activity, ArtikelYolaActivity::class.java)
            startActivity(intent)
        }
        if (v?.id == R.id.button_ebook){
            val intent = Intent(activity, EbookActivity::class.java)
            startActivity(intent)
        }
        if (v?.id == R.id.button_chat){
            val intent = Intent(activity, ChatActivity::class.java)
            startActivity(intent)
        }
        if (v?.id == R.id.button_share){
            val intent = Intent(activity, PusatBantuanActivity::class.java)
            startActivity(intent)
        }
        if (v?.id == R.id.button_notif){
            val intent = Intent(activity, NotifActivity::class.java)
            startActivity(intent)
        }
    }
}