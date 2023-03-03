package com.maktbesharif.hw_13_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState != null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<ColoringFragment>(R.id.fragmentContainerView)
            }
        }
    }
}