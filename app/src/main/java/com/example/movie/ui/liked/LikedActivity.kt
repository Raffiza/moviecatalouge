package com.example.movie.ui.liked

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie.databinding.ActivityLikedBinding


class LikedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityLikedBinding = ActivityLikedBinding.inflate(layoutInflater)
        setContentView(activityLikedBinding.root)

        supportActionBar?.title = "Liked Movie and TV Show"

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        activityLikedBinding.viewPager.adapter = sectionsPagerAdapter
        activityLikedBinding.tabs.setupWithViewPager(activityLikedBinding.viewPager)

        supportActionBar?.elevation = 0f
    }


}