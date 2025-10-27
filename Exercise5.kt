<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <!-- Top image -->

    <!-- Bottom image -->

    <ImageSwitcher
        android:id="@+id/imageSwitcherTop"
        android:layout_width="96dp"
        android:layout_height="91dp"
        android:layout_marginTop="236dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <ImageSwitcher
        android:id="@+id/imageSwitcherBottom"
        android:layout_width="200dp"
        android:layout_height="200dp"
        app:layout_constraintTop_toBottomOf="@id/imageSwitcherTop"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="24dp" />

    <!-- Button -->
    <Button
        android:id="@+id/buttonSwitch"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Switch Image"
        app:layout_constraintTop_toBottomOf="@id/imageSwitcherBottom"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="24dp" />

</androidx.constraintlayout.widget.ConstraintLayout>
package com.example.finallab1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.ViewSwitcher
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var imageSwitcherTop: ImageSwitcher
    private lateinit var imageSwitcherBottom: ImageSwitcher

    // Two sample images
    private val images = intArrayOf(R.drawable.cat1, R.drawable.cat2)

    // Track which image each switcher currently shows
    private var topIndex = 0
    private var bottomIndex = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageSwitcherTop = findViewById(R.id.imageSwitcherTop)
        imageSwitcherBottom = findViewById(R.id.imageSwitcherBottom)
        val buttonSwitch: Button = findViewById(R.id.buttonSwitch)

        // Function to create ImageViews for both ImageSwitchers
        fun createImageView(): ImageView {
            val imageView = ImageView(applicationContext)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            return imageView
        }

        // Set factories for both ImageSwitchers
        imageSwitcherTop.setFactory { createImageView() }
        imageSwitcherBottom.setFactory { createImageView() }

        // Optional fade animation
        imageSwitcherTop.setInAnimation(this, android.R.anim.fade_in)
        imageSwitcherTop.setOutAnimation(this, android.R.anim.fade_out)
        imageSwitcherBottom.setInAnimation(this, android.R.anim.fade_in)
        imageSwitcherBottom.setOutAnimation(this, android.R.anim.fade_out)

        // Set initial images
        imageSwitcherTop.setImageResource(images[topIndex])
        imageSwitcherBottom.setImageResource(images[bottomIndex])

        // Button click: swap images
        buttonSwitch.setOnClickListener {
            // Swap indices
            val temp = topIndex
            topIndex = bottomIndex
            bottomIndex = temp

            // Apply new images
            imageSwitcherTop.setImageResource(images[topIndex])
            imageSwitcherBottom.setImageResource(images[bottomIndex])
        }
    }
}
