<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="24dp">

    <!-- Standard Button -->
    <Button
        android:id="@+id/btnStandard"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Click Me"
        android:layout_marginBottom="16dp" />

    <!-- Image Button -->
    <ImageButton
        android:id="@+id/btnImage"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/ic_launcher_foreground"
        android:contentDescription="Image Button"
        android:background="@null"
        android:layout_marginBottom="16dp" />

    <!-- Toggle Button -->
    <ToggleButton
        android:id="@+id/btnToggle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textOn="ON"
        android:textOff="OFF" />

</LinearLayout>
  package com.example.finallab1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Step 2: Find views by ID
        val btnStandard = findViewById<Button>(R.id.btnStandard)
        val btnImage = findViewById<ImageButton>(R.id.btnImage)
        val btnToggle = findViewById<ToggleButton>(R.id.btnToggle)

        // Step 3: Add onClick event handlers with Toast messages

        // Standard Button
        btnStandard.setOnClickListener {
            Toast.makeText(this, "Standard Button clicked!", Toast.LENGTH_SHORT).show()
        }

        // Image Button
        btnImage.setOnClickListener {
            Toast.makeText(this, "Image Button clicked!", Toast.LENGTH_SHORT).show()
        }

        // Toggle Button
        btnToggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Toggle is ON", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Toggle is OFF", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
