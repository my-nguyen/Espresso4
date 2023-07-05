package com.nguyen.espresso4.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.nguyen.espresso4.databinding.ActivityEnterNameBinding

class EnterNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEnterNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextButton.setOnClickListener(View.OnClickListener {
            val name = binding.nameEdittext.text.toString().trim {
                it <= ' '
            }
            if (name.isNotEmpty()) {
                binding.errorText.visibility = View.INVISIBLE
                val intent = Intent(this@EnterNameActivity, DisplayNameActivity::class.java)
                intent.putExtra(NAME, name)
                startActivity(intent)
            } else {
                binding.errorText.visibility = View.VISIBLE
            }
        })
    }

    companion object {
        const val NAME = "text"
    }
}