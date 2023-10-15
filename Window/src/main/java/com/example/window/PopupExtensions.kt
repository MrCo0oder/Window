package com.example.window

import android.graphics.Typeface
import android.text.method.ScrollingMovementMethod
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AlertDialog


fun AlertDialog.animation(
    res: Int?
): AlertDialog {
    if (res != null) {
        Popup.binding.lottieAnimationView.apply {
            setAnimation(res)
            show()
        }
    } else {
        Popup.binding.lottieAnimationView.apply {
            gone()
        }
    }
    return this
}

fun AlertDialog.icon(
    icon: Int?
): AlertDialog {
    if (icon != null) {
        Popup.binding.icon.setImageResource(icon)
        Popup.binding.icon.show()
    } else {
        Popup.binding.icon.gone()
    }
    return this
}

fun AlertDialog.header(
    title: String = "", fontStyle: Typeface? = null, titleColor: Int = 0
): AlertDialog {
    if (!title.isNullOrBlank()) {
        Popup.binding.header.text = title
        /*    Popup.binding.header.movementMethod = ScrollingMovementMethod()
            Popup.binding.header.setHorizontallyScrolling(true)*/
        if (fontStyle != null) {
            Popup.binding.header.typeface = fontStyle
        }
        if (titleColor != 0) {
            Popup.binding.header.setTextColor(titleColor)
        }
        Popup.binding.header.show()
    } else {
        Popup.binding.header.gone()
    }
    return this
}

fun AlertDialog.body(
    body: String = "",
    fontStyle: Typeface? = null,
    titleColor: Int = 0
): AlertDialog {
    if (!body.isNullOrBlank()) {
        Popup.binding.body.text = body
        Popup.binding.body.movementMethod = ScrollingMovementMethod()
        if (fontStyle != null) {
            Popup.binding.body.typeface = fontStyle
        }
        if (titleColor != 0) {
            Popup.binding.body.setTextColor(titleColor)
        }
        Popup.binding.body.show()
    } else {
        Popup.binding.body.gone()
    }
    return this
}


fun AlertDialog.onPositive(
    text: String? = null,
    buttonBackground: Int? = null,
    textColor: Int? = null,
    onClick: (() -> Unit)? = null
): AlertDialog {
    Popup.binding.buttonsLayout.show()
    Popup.binding.positiveButton.show()
    if (text != null) {
        Popup.binding.positiveButton.text = text.trim()
        if (textColor != null) {
            Popup.binding.positiveButton.setTextColor(textColor)
        }
        if (buttonBackground != null) {
            Popup.binding.positiveButton.setBackgroundResource(buttonBackground)
            Popup.binding.positiveButton.elevation = 5.0f
        }
        Popup.binding.positiveButton.setOnClickListener {
            onClick?.invoke()
            dismiss()
        }
    } else {
        Popup.binding.positiveButton.gone()
    }
    return this
}


fun AlertDialog.onNegative(
    text: String? = null,
    buttonBackground: Int? = null,
    textColor: Int? = null,
    onClick: (() -> Unit)? = null
): AlertDialog {
    Popup.binding.buttonsLayout.show()
    Popup.binding.negativeButton.show()
    if (text != null) {
        Popup.binding.negativeButton.text = text.trim()
        if (textColor != null) {
            Popup.binding.negativeButton.setTextColor(textColor)
        }
        if (buttonBackground != null) {
            Popup.binding.negativeButton.setBackgroundResource(buttonBackground)
            Popup.binding.negativeButton.elevation = 5.0f
        }
        Popup.binding.negativeButton.setOnClickListener {
            onClick?.invoke()
            dismiss()
        }
    } else {
        Popup.binding.negativeButton.gone()
    }
    return this
}

fun AlertDialog.background(
    backgroundColor: Int? = null
): AlertDialog {
    if (backgroundColor != null) {
        Popup.binding.mainCard.setCardBackgroundColor(backgroundColor)
    }
    return this
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun AlertDialog.position(
    position: Popup.POSITIONS = Popup.POSITIONS.BOTTOM
): AlertDialog {
    when (position) {
        Popup.POSITIONS.BOTTOM -> {
            this.window?.setGravity(Gravity.BOTTOM)
        }

        Popup.POSITIONS.CENTER -> {
            this.window?.setGravity(Gravity.CENTER)
        }
    }
    return this
}

fun AlertDialog.isCancelable(isCancelable: Boolean): AlertDialog {
    this.setCancelable(isCancelable)
    return this
}
