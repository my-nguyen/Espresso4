package com.nguyen.espresso4.activities

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nguyen.espresso4.databinding.ActivityDateTimePickerBinding
import java.util.Calendar

class DateTimePickerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDateTimePickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDateTimePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.datePickerButton.setOnClickListener{
            showDatePickerDialog()
        }
        binding.timePickerButton.setOnClickListener{
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar[Calendar.HOUR_OF_DAY]
        val minute = calendar[Calendar.MINUTE]
        val timePicker = TimePickerDialog(this, { view, hourOfDay, minute ->
            binding.status.text = "$hourOfDay:$minute"
        }, hour, minute, true)
        timePicker.setTitle("Pick a time")
        timePicker.show()
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerDialog(this, { view, year, monthOfYear, dayOfMonth ->
            binding.status.text = "$year/$monthOfYear/$dayOfMonth"
        }, 2015, 0, 1)
        datePicker.setTitle("Pick a date")
        datePicker.show()
    }
}