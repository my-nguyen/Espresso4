package com.nguyen.espresso4.activities

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.nguyen.espresso4.databinding.ActivitySpinnerSelectionBinding

class SpinnerSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySpinnerSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*binding.countriesSpinner.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.emailAddressTypes,
            R.layout.simple_spinner_dropdown_item
        )*/
        binding.countriesSpinner.setOnItemClickListener { parent, view, position, id ->
            if (position > 0) {
                binding.countryLabel.text = parent.selectedItem as CharSequence
            }
        }
    }
}