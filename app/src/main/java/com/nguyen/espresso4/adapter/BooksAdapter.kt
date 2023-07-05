package com.nguyen.espresso4.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.nguyen.espresso4.R
import com.nguyen.espresso4.models.Book

/**
 * Adapter that provides views for the list
 */
class BooksAdapter(private val items: List<Book>) : BaseAdapter() {
    override fun getCount() = items.size

    override fun getItem(position: Int) = items[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val convertView = view ?:
                LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        val bookTitle = convertView.findViewById<View>(R.id.book_title) as TextView
        bookTitle.text = items[position].title
        val bookAuthor = convertView.findViewById<View>(R.id.book_author) as TextView
        bookAuthor.text = "by " + items[position].author
        return convertView
    }
}