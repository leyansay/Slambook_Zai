package com.example.slambook

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home) // Replace with your layout

        // Retrieve the combined data from the Intent
        val allData = intent.getStringArrayListExtra("ALL_DATA")


        if (allData != null) {
            // Display the combined data, for example, in a TextView
            val textView = findViewById<TextView>(R.id.textView) // Replace with your TextView ID
            textView.text = allData.joinToString("\n")
        }

        findViewById<ImageView>(R.id.addButton).setOnClickListener {
            val intent = Intent(this, SlamFill1::class.java)
            startActivity(intent)
        }

    }
}
