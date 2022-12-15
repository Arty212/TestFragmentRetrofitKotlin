package com.example.testfragment.ui.activity

import android.os.Bundle
import com.example.testfragment.R
import com.example.testfragment.ui.fragment.ListFragment
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listFragment = ListFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_list, listFragment)
            .addToBackStack(null).commit()
    }
}