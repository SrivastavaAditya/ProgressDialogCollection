package com.example.customprogressdialogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dialog = DialogUtil.builder(this@MainActivity)
            .getDefaultDialog()
            .setDefaultDialogText("Aditya")
            .build()

    }
}
