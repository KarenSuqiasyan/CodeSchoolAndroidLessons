package com.cshomework.codeschoolandroidlessons.recyclerview_countries.ui.countrydetails

import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.common.codeschoolandroidlessons.databinding.ActivityCountryDetailsBinding
import com.cshomework.codeschoolandroidlessons.recyclerview_countries.ui.adapter.CountryAdapter.Companion.COUNTRIES_ENUM_DESCRIPTION
import com.cshomework.codeschoolandroidlessons.recyclerview_countries.ui.adapter.CountryAdapter.Companion.COUNTRIES_ENUM_FLAG
import com.cshomework.codeschoolandroidlessons.recyclerview_countries.ui.adapter.CountryAdapter.Companion.COUNTRIES_ENUM_TITLE
import kotlin.math.max
import kotlin.math.min

class CountryDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCountryDetailsBinding
    private lateinit var scaleGestureDetector: ScaleGestureDetector
    private var scaleFactor = 1.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.detailsTextView.text = intent.getStringExtra(COUNTRIES_ENUM_DESCRIPTION)
        binding.titleTextview2.text = intent.getStringExtra(COUNTRIES_ENUM_TITLE)
        Glide.with(this).load(intent.getStringExtra(COUNTRIES_ENUM_FLAG)).into(binding.flagImageview2)
//        Glide.with(this).load(intent.getStringExtra(COUNTRIES_ENUM_FLAG2)).into(binding.flagImageview3)

        scaleGestureDetector = ScaleGestureDetector(this, ScaleListener())

    }
    override fun onTouchEvent(motionEvent: MotionEvent): Boolean {
        scaleGestureDetector.onTouchEvent(motionEvent)
        return true
    }
    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(scaleGestureDetector: ScaleGestureDetector): Boolean {
            scaleFactor *= scaleGestureDetector.scaleFactor
            scaleFactor = max(0.1f, min(scaleFactor, 10.0f))
            binding.flagImageview3.scaleX = scaleFactor
            binding.flagImageview3.scaleY = scaleFactor
            return true
        }
    }

}