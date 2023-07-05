package com.nguyen.espresso4.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.nguyen.espresso4.Database
import com.nguyen.espresso4.R
import com.nguyen.espresso4.adapter.BooksAdapter
import com.nguyen.espresso4.databinding.ActivityCustomListBinding
import com.nguyen.espresso4.models.Book

class CustomListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCustomListBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_custom_list)

        binding.list.adapter = BooksAdapter(Database.ALL_BOOKS)
        binding.list.setOnItemClickListener { parent, view, position, id ->
            val book = parent.getItemAtPosition(position) as Book
            val intent = Intent(this@CustomListActivity, BookDetailsActivity::class.java)
            intent.putExtra(BookDetailsActivity.TITLE, book.title)
            intent.putExtra(BookDetailsActivity.AUTHOR, book.author)
            startActivity(intent)
        }
    }
}