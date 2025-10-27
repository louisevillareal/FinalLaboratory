<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <!-- Step 1: TextView for instructions -->
    <TextView
        android:id="@+id/tvInstruction"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="Enter your name, choose a color, and pick a course;"
        android:textSize="18sp"
        android:textColor="@android:color/black"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_margin="24dp"
        android:gravity="center"/>

    <!-- Step 2: EditText for user input -->
    <EditText
        android:id="@+id/etName"
        android:layout_width="0dp"
        android:layout_height="48dp"
        android:hint="Enter your name"
        android:padding="8dp"
        android:textColor="@android:color/black"
        android:backgroundTint="@color/teal_700"
        app:layout_constraintTop_toBottomOf="@id/tvInstruction"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginHorizontal="24dp"
        android:layout_marginTop="16dp"/>

    <!-- Step 3: AutoCompleteTextView with sample countries -->
    <AutoCompleteTextView
        android:id="@+id/autoColor"
        android:layout_width="0dp"
        android:layout_height="48dp"
        android:hint="Choose your favorite Color"
        android:textSize="16sp"
        android:padding="8dp"
        android:backgroundTint="@color/teal_700"
        app:layout_constraintTop_toBottomOf="@id/etName"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginHorizontal="24dp"
        android:layout_marginTop="16dp"/>

    <!-- Step 4: Spinner with 5 sample options -->
    <Spinner
        android:id="@+id/spinnerOptions"
        android:layout_width="0dp"
        android:layout_height="48dp"
        app:layout_constraintTop_toBottomOf="@id/autoColor"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginHorizontal="24dp"
        android:layout_marginTop="16dp"/>

</androidx.constraintlayout.widget.ConstraintLayout>
  package com.example.finallab1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Step 3: Setup AutoCompleteTextView
        val colors = arrayOf("Red", "Blue", "Green", "Orange", "Black")
        val autoColor = findViewById<AutoCompleteTextView>(R.id.autoColor)
        val colorAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, colors)
        autoColor.setAdapter(colorAdapter)

        // Step 4: Setup Spinner
        val spinnerOptions = findViewById<Spinner>(R.id.spinnerOptions)
        val courses = arrayOf("BSIT", "BSCS", "BSBA", "BCRIM", "BSED")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, courses)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOptions.adapter = spinnerAdapter
    }
}
