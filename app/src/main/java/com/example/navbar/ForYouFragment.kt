package com.example.navbar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ForYouFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_for_you, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btntextview: TextView = view.findViewById(R.id.textViewTitlecontoh)
        btntextview.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.textViewTitlecontoh){
            val intent = Intent(activity, ContohArtikelActivity::class.java)
            startActivity(intent)
        }
    }
}