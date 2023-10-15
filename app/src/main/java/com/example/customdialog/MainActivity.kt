package com.example.customdialog

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.customdialog.databinding.ActivityMainBinding
import com.example.window.LoadingPopup
import com.example.window.Popup
import com.example.window.animation
import com.example.window.background
import com.example.window.body
import com.example.window.gone
import com.example.window.header
import com.example.window.icon
import com.example.window.isCancelable
import com.example.window.onNegative
import com.example.window.onPositive
import com.example.window.position
import com.example.window.progressAnimation
import com.example.window.progressBackground
import com.example.window.progressDescription

class MainActivity : AppCompatActivity() {
    private lateinit var alertButton: Button
    private lateinit var loadingButton: Button
    private lateinit var radioGroup: RadioGroup
    lateinit var binding: ActivityMainBinding
    lateinit var popup: AlertDialog

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        popup = Popup.init(this)
        alertButton = findViewById(R.id.alert_button)
        loadingButton = findViewById(R.id.loading_button)

        initAlertDialogButton()
        initLoadingDialogButton()
        binding.backgroundLayout.group.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                binding.backgroundLayout.option1.id -> {
                    popup.background(getColor(R.color.purple))
                }

                binding.backgroundLayout.option2.id -> {
                    popup.background(getColor(R.color.black))
                }

                binding.backgroundLayout.option3.id -> {
                    popup.background(getColor(R.color.yellow))
                }
            }
        }
        binding.iconLayout.group.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                binding.iconLayout.option1.id -> {
                    popup.icon(com.example.window.R.drawable.image)
                    popup.animation(null)
                }

                binding.iconLayout.option2.id -> {
                    popup.animation(R.raw.lottie)
                    popup.icon(null)

                }

                binding.iconLayout.option3.id -> {
                    popup.animation(null)
                    popup.icon(null)
                }
            }
        }
        binding.titleLayout.group.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                binding.titleLayout.option1.id -> {
                    popup.header(getString(R.string.dialog_gamed))
                }

                binding.titleLayout.option2.id -> {
                    popup.header()
                }
            }
        }
        binding.bodyLayout.group.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                binding.bodyLayout.option1.id -> {
                    popup.body(getString(R.string.this_is_a_nice_multi_line_body))
                }

                binding.bodyLayout.option2.id -> {
                    popup.body()
                }
            }
        }
        binding.btnsLayout
            .group.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    binding.btnsLayout.option1.id -> {
                        popup.onPositive("Ok",
                            R.drawable.buttons_background,
                            onClick = { toast(getString(R.string.ok).plus("😎")) })
                        popup.onNegative()
                    }

                    binding.btnsLayout.option2.id -> {
                        popup.onPositive("Ok",
                            R.drawable.buttons_background,
                            onClick = { toast(getString(R.string.ok).plus("😎")) })
                        popup.onNegative("Cancel", R.drawable.buttons_background,
                            onClick = { toast(getString(R.string.cancel).plus("🤷‍♂️")) })
                    }

                    binding.btnsLayout.option3.id -> {
                        popup.onPositive()
                        popup.onNegative()
                    }
                }
            }
        binding.dismissableLayout
            .group.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    binding.dismissableLayout.option1.id -> {
                        popup.isCancelable(true)
                    }

                    binding.dismissableLayout.option2.id -> {
                        popup.isCancelable(false)
                    }
                }
            }
        binding.positionLayout
            .group.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    binding.dismissableLayout.option1.id -> {
                        popup.position(Popup.POSITIONS.BOTTOM)
                    }

                    binding.dismissableLayout.option2.id -> {
                        popup.position(Popup.POSITIONS.CENTER)
                    }
                }
            }
    }

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    private fun initUI() {
        binding.apply {

            backgroundLayout.apply {
                option1.apply {
                    setTextColor(R.color.purple)
                    text = "Purple"
                }
                option2.apply {
                    text = "Black"
                }
                option3.apply {
                    setTextColor(ContextCompat.getColor(context, R.color.yellow));
                    text = "Yellow"
                }
            }
            iconLayout.apply {
                option1.apply {
                    text = "Icon"
                }
                option2.apply {
                    text = "Lottie anim"
                }
                option3.apply {
                    text = "NONE"
                }
            }
            titleLayout.apply {
                option1.apply {
                    text = "Has Title"
                }
                option2.apply {
                    text = "NONE"
                }
                option3.gone()
            }
            bodyLayout.apply {
                option1.apply {
                    text = "Has Body"
                }
                option2.apply {
                    text = "NONE"
                }
                option3.gone()
            }
            btnsLayout.apply {
                option1.apply {
                    text = "+PV Button"
                }
                option2.apply {
                    text = "-NV Button"
                }
                option3.apply {
                    text = "NONE"
                }
            }
            dismissableLayout.apply {
                option1.apply {
                    text = "True"
                }
                option2.apply {
                    text = "False"
                }
                option3.gone()
            }
            positionLayout.apply {
                option1.apply {
                    text = "Bottom"
                }
                option2.apply {
                    text = "Center"
                }
                option3.gone()
            }
        }
    }

    private fun initLoadingDialogButton() {
        loadingButton.setOnClickListener {
            LoadingPopup.init(this)
                .progressAnimation()
                .progressBackground(R.color.yellow)
                .progressDescription(
                    "This is a \n nice multi-line body.",
                    titleColor = R.color.white
                )
                //just for testing
                .isCancelable(true)


        }
    }

    private fun initAlertDialogButton() {
        alertButton.setOnClickListener {
            popup.show()
//            .header(getString(R.string.dialog_gamed))
//            //                .animation(R.raw.lottie)
//            .body(getString(R.string.this_is_a_nice_multi_line_body))
//            .onPositive(getString(R.string.ok),
//                R.drawable.buttons_background,
//                onClick = { toast(getString(R.string.ok).plus("😎")) })
//            .onNegative(
//                getString(R.string.cancel),
//                null,
//                onClick = { toast(getString(R.string.cancel).plus("🤷‍♂️")) })
//            .isCancelable(false)
//            .position(Popup.POSITIONS.BOTTOM)
//            .background(getColor(com.example.window.R.color.purple300))
//            .icon(com.example.window.R.drawable.image)
        }
    }
    /*    private fun initAlertDialogButton() {
            alertButton.setOnClickListener {
                Popup.init(this)
                    .header(getString(R.string.dialog_gamed))
                    //                .animation(R.raw.lottie)
                    .body(getString(R.string.this_is_a_nice_multi_line_body))
                    .onPositive(getString(R.string.ok),
                        R.drawable.buttons_background,
                        onClick = { toast(getString(R.string.ok).plus("😎")) })
                    .onNegative(
                        getString(R.string.cancel),
                        null,
                        onClick = { toast(getString(R.string.cancel).plus("🤷‍♂️")) })
                    .isCancelable(false)
                    .position(Popup.POSITIONS.BOTTOM)
                    .background(getColor(com.example.window.R.color.purple300))
                    .icon(com.example.window.R.drawable.image)
            }
        }*/

    private fun toast(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }
}


