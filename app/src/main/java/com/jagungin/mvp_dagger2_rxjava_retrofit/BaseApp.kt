package com.jagungin.mvp_dagger2_rxjava_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class BaseApp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
