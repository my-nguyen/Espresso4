package com.nguyen.espresso4.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nguyen.espresso4.R
import com.nguyen.espresso4.databinding.ActivityBookDetailsBinding

class BookDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBookDetailsBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_book_details)

        binding.bookTitle.setText(getIntent().getStringExtra(TITLE))
        binding.bookAuthor.setText(getIntent().getStringExtra(AUTHOR))
    }

    companion object {
        const val TITLE = "title"
        const val AUTHOR = "author"
    }
}