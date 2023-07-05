package com.nguyen.espresso4.activities

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nguyen.espresso4.R
import com.nguyen.espresso4.databinding.ActivityDialogExampleBinding

class DialogExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDialogExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDialogExampleBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_dialog_example)

        binding.confirmDialogButton.setOnClickListener{
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.dialog_title)
        builder.setMessage(R.string.dialog_message)
        builder.setNegativeButton(R.string.cancel) { dialog, which ->
            binding.statusText.text = getString(R.string.cancel)
        }
        builder.setPositiveButton(R.string.ok) { dialog, which ->
            binding.statusText.setText(getString(R.string.ok))
        }
        builder.create().show()
    }
}