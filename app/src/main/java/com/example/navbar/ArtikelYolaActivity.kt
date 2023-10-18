package com.example.navbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import com.example.navbar.databinding.ActivityArtikelYolaBinding
import com.google.android.material.tabs.TabLayoutMediator

class ArtikelYolaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtikelYolaBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtikelYolaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        with(binding){
            viewPager.adapter = viewPagerAdapter

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when(position){
                    0 -> tab.text = "For You"
                    1 -> tab.text = "Recomendation"
                    2 -> tab.text = "Treding"
                }
            }.attach()
        }
    }
}