<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#FAFAFA"
    android:padding="16dp"
    tools:context=".MainActivity">

  
    <TextView
        android:id="@+id/titleText"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="Welcome to My App"
        android:textColor="#222222"
        android:textSize="24sp"
        android:textStyle="bold"
        android:fontFamily="sans-serif-medium"
        android:gravity="center"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="24dp" />

    <!-- Image with accessibility description -->
    <ImageView
        android:id="@+id/catImage"
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:src="@drawable/cat1"
        android:contentDescription="Image of a cute cat"
        app:layout_constraintTop_toBottomOf="@id/titleText"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="24dp"
        android:scaleType="centerCrop" />

    <!-- Name input field -->
    <EditText
        android:id="@+id/nameField"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Enter your name"
        android:inputType="textPersonName"
        android:padding="12dp"
        android:background="@android:drawable/edit_text"
        app:layout_constraintTop_toBottomOf="@id/catImage"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="24dp" />

    <!-- Submit button -->
    <Button
        android:id="@+id/submitButton"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="Submit"
        android:textAllCaps="false"
        android:textColor="#FFFFFF"
        android:backgroundTint="#3F51B5"
        android:layout_marginTop="16dp"
        android:padding="12dp"
        app:layout_constraintTop_toBottomOf="@id/nameField"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />

    <!-- Cancel button -->
    <Button
        android:id="@+id/cancelButton"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="Cancel"
        android:textAllCaps="false"
        android:textColor="#FFFFFF"
        android:backgroundTint="#9E9E9E"
        android:layout_marginTop="12dp"
        android:padding="12dp"
        app:layout_constraintTop_toBottomOf="@id/submitButton"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
  package com.example.finallab1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        val titleText: TextView = findViewById(R.id.titleText)
        val catImage: ImageView = findViewById(R.id.catImage)
        val nameField: EditText = findViewById(R.id.nameField)
        val submitButton: Button = findViewById(R.id.submitButton)
        val cancelButton: Button = findViewById(R.id.cancelButton)

        // Title click example (optional)
        titleText.setOnClickListener {
            Toast.makeText(this, "Welcome to the UI Design Exercise!", Toast.LENGTH_SHORT).show()
        }

        // Image click example
        catImage.setOnClickListener {
            Toast.makeText(this, "You clicked the cat image 🐱", Toast.LENGTH_SHORT).show()
        }

        // Submit button click
        submitButton.setOnClickListener {
            val name = nameField.text.toString().trim()
            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter your name.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Hello, $name!", Toast.LENGTH_SHORT).show()
            }
        }

        // Cancel button click
        cancelButton.setOnClickListener {
            nameField.text.clear()
            Toast.makeText(this, "Input cleared.", Toast.LENGTH_SHORT).show()
        }
    }
}
