package com.cshomework.codeschoolandroidlessons.multiple_recyclerview.ui.activity.fullscreenimage

import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.common.codeschoolandroidlessons.databinding.ActivityFullScreenImageBinding
import com.cshomework.codeschoolandroidlessons.multiple_recyclerview.ui.adapter.PostAdapter
import kotlin.math.max
import kotlin.math.min

class FullScreenImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullScreenImageBinding
    private lateinit var scaleGestureDetector: ScaleGestureDetector
    private var scaleFactor = 1.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this).load(intent.getStringExtra(PostAdapter.FULL_SCREEN_IMAGE)).into(binding.fullScreenImageView)
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
            binding.fullScreenImageView.scaleX = scaleFactor
            binding.fullScreenImageView.scaleY = scaleFactor
            return true
        }
    }
}