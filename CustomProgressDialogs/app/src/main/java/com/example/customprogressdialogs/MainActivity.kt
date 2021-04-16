package com.example.customprogressdialogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dialog = DialogUtil.builder(this@MainActivity)
            .getDialog(DialogType.LINEAR)
            .setText(resources.getString(R.string.text_loading_please_Wait))
            .setProgress(1000)
            .setDuration(10000)
            .setInterval(25)
            .build()

        dialog.show()

    }
}
