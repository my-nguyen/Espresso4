package com.nguyen.espresso4.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nguyen.espresso4.databinding.ActivityDisplayNameBinding

class DisplayNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDisplayNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val text = intent.getStringExtra(EnterNameActivity.NAME)
        binding.greetingMessage.text = "Hello $text!"
    }
}