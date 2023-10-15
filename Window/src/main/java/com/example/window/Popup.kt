package com.example.window

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Typeface
import android.text.method.ScrollingMovementMethod
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.window.databinding.PopupBinding

class Popup {
    enum class POSITIONS {
        CENTER, BOTTOM
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var binding: PopupBinding
        private lateinit var layoutInflater: LayoutInflater
        fun init(activity: Activity): AlertDialog {
            layoutInflater = LayoutInflater.from(activity)
            binding = PopupBinding.inflate(layoutInflater, null, false)
            val alertDialog =
                AlertDialog.Builder(activity, R.style.full_screen_dialog).setView(binding.root)
            val alert: AlertDialog = alertDialog.create()
            return alert
        }
    }
}
