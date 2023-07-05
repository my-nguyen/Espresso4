package com.nguyen.espresso4.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nguyen.espresso4.Database
import com.nguyen.espresso4.activities.BookDetailsActivity
import com.nguyen.espresso4.databinding.ItemBookBinding
import com.nguyen.espresso4.models.Book

/**
 * The adapter used by RecyclerView to display books.
 *
 * @author vgrec, created on 3/30/15.
 */
class RecyclerBooksAdapter() : RecyclerView.Adapter<RecyclerBooksAdapter.RowHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBookBinding.inflate(inflater, parent, false)
        return RowHolder(binding)
    }

    override fun getItemCount() = Database.ALL_BOOKS.size

    override fun onBindViewHolder(rowHolder: RowHolder, i: Int) {
        rowHolder.bindModel(Database.ALL_BOOKS[i])
    }

    inner class RowHolder(private val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            binding.root.setOnClickListener(this)
        }

        fun bindModel(book: Book) {
            binding.bookAuthor.text = book.title
            binding.bookAuthor.text = book.author
        }

        override fun onClick(v: View) {
            val book = Database.ALL_BOOKS[adapterPosition]
            val intent = Intent(v.context, BookDetailsActivity::class.java)
            intent.putExtra(BookDetailsActivity.TITLE, book.title)
            intent.putExtra(BookDetailsActivity.AUTHOR, book.author)
            v.context.startActivity(intent)
        }
    }
}