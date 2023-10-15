package com.example.window

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.window.databinding.LoadingPopupBinding

class LoadingPopup {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var binding: LoadingPopupBinding
        private lateinit var layoutInflater: LayoutInflater
        fun init(activity: Activity): AlertDialog {
            layoutInflater = LayoutInflater.from(activity)
            binding = LoadingPopupBinding.inflate(layoutInflater, null, false)
            val alertDialog =
                AlertDialog.Builder(activity, R.style.full_screen_dialog).setView(binding.root)
            val alert: AlertDialog = alertDialog.create()
                .isCancelable(false)
            alert.show()
            return alert
        }
    }
}
