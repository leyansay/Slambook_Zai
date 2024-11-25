package com.example.slambook

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Retrieve data from SharedPreferences
        val sharedPreferences = getSharedPreferences("SlamBookPrefs", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("NAME", null)
        val nickname = sharedPreferences.getString("NICKNAME", null)
        val age = sharedPreferences.getInt("AGE", -1) // Use -1 as a marker for no data
        val gender = sharedPreferences.getString("GENDER", null)
        val hometown = sharedPreferences.getString("HOMETOWN", null)
        val color = sharedPreferences.getString("COLOR", null)
        val food = sharedPreferences.getString("FOOD", null)
        val comfortfood = sharedPreferences.getString("COMFORT FOOD", null)
        val place = sharedPreferences.getString("PLACE", null)
        val hobbies = sharedPreferences.getString("HOBBIES", null)
        val sports = sharedPreferences.getString("SPORTS", null)


        // Check if all fields are empty
        val isDataAvailable = name != null || nickname != null || age != -1 || gender != null || hometown != null || color != null || food != null || comfortfood != null || place != null || hobbies != null || sports != null

        // Handle empty data state
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val emptyTextView = findViewById<TextView>(R.id.emptyTextViewHolder) // Add a placeholder TextView in your layout

        if (isDataAvailable) {
            // Prepare data for RecyclerView
            val dataList = mutableListOf<String>()
            if (!name.isNullOrEmpty()) dataList.add("Name: $name")
            if (!nickname.isNullOrEmpty()) dataList.add("Nickname: $nickname")
            if (age != -1) dataList.add("Age: $age")
            if (!gender.isNullOrEmpty()) dataList.add("Gender: $gender")
            if (!hometown.isNullOrEmpty()) dataList.add("Hometown: $hometown")
            if (!color.isNullOrEmpty()) dataList.add("Color: $color")
            if (!food.isNullOrEmpty()) dataList.add("Food: $food")
            if (!comfortfood.isNullOrEmpty()) dataList.add("Comfort Food: $comfortfood")
            if (!place.isNullOrEmpty()) dataList.add("Place: $place")
            if (!hobbies.isNullOrEmpty()) dataList.add("Hobbies: $hobbies")
            if (!sports.isNullOrEmpty()) dataList.add("Sports: $sports")


            // Show RecyclerView and hide empty placeholder
            emptyTextView.visibility = View.GONE
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = LayoutAdapter(dataList)
        } else {
            // Show empty placeholder and hide RecyclerView
            emptyTextView.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        }

        findViewById<ImageButton>(R.id.addButton).setOnClickListener {
            // Define the action you want to take when the button is clicked
            val intent = Intent(this, SlamFill1::class.java)  // Example: Navigating to another activity
            startActivity(intent)
        }

    }
}
