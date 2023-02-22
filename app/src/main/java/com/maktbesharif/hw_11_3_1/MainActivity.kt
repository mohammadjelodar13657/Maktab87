package com.maktbesharif.hw_11_3_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(svedInstanceState: Bundle?) {
        super.onCreate(svedInstanceState)
        setContentView(R.layout.activity_main)
        if(svedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<LoginFragment>(R.id.fragment_container_view)
            }
        }
    }
}