package com.cursokotlin.quizapp

import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.ProgressBar


class CircularAnimation(
    private val progressBar: ProgressBar,
    private val from: Int = 0,
    private val to: Int
) : Animation() {

    override fun applyTransformation(
        interpolatedTime: Float,
        t: Transformation?
    ) {
        super.applyTransformation(interpolatedTime, t)
        val value = from + (to - from) * interpolatedTime
        progressBar.progress = value.toInt()
    }

}