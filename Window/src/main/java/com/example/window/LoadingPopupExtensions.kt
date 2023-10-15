package com.example.window

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat


@SuppressLint("ResourceAsColor")
fun AlertDialog.progressAnimation(
    res: Int?=null
): AlertDialog {
    if (res != null) {
        LoadingPopup.binding.lottieAnimationView.apply {
            setAnimation(res)
            show()
            LoadingPopup.binding.lottieAnimationView.show()
            LoadingPopup.binding.progressBar.gone()
        }
    }else{
        LoadingPopup.binding.progressBar.show()
    }
    return this
}


fun AlertDialog.progressDescription(
    progressDescription: String = "",
    fontStyle: Typeface? = null,
    titleColor: Int? = null
): AlertDialog {
    LoadingPopup.binding.progressDesc.text = progressDescription
    LoadingPopup.binding.progressDesc.movementMethod = ScrollingMovementMethod()
    if (fontStyle != null) {
        LoadingPopup.binding.progressDesc.typeface = fontStyle
    }
    if (titleColor != null) {
        LoadingPopup.binding.progressDesc.setTextColor(ContextCompat.getColor(context, titleColor))
    }
    LoadingPopup.binding.progressDesc.show()
    return this
}

fun AlertDialog.progressBackground(
    backgroundColor: Int? = null
): AlertDialog {
    if (backgroundColor != null) {
//        LoadingPopup.binding.mainCard.setCardBackgroundColor(backgroundColor)
        LoadingPopup.binding.mainCard.background =
            LoadingPopup.binding.mainCard.context.getDrawable(backgroundColor)
    }
    return this
}

