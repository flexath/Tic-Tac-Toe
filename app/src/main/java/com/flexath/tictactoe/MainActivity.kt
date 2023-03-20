package com.flexath.tictactoe

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.acitvity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitvity_main)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val logoAnimation = AnimationUtils.loadAnimation(this,R.anim.fade_anim)

        logoAnimation.duration = 3000
        logoImage.startAnimation(logoAnimation)
        logoText.startAnimation(logoAnimation)

        Handler(Looper.getMainLooper()).postDelayed({
            Intent(this,GameActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }, 3000)
        finishActivity(0)
    }
}