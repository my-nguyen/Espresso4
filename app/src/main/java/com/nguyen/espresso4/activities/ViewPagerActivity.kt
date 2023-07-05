package com.nguyen.espresso4.activities

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nguyen.espresso4.Database
import com.nguyen.espresso4.R
import com.nguyen.espresso4.adapter.BooksAdapter
import com.nguyen.espresso4.databinding.ActivityViewPagerBinding
import com.nguyen.espresso4.models.Book

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pager.adapter = ViewPagerAdapter(supportFragmentManager)
    }

    private inner class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
        private val tabs = arrayOf("New", "All")

        private fun newBooksFragment(position: Int): Fragment {
            val args = Bundle()
            args.putInt("tab_index", position)
            val fragment = BooksFragment()
            fragment.arguments = args
            return fragment
        }

        override fun getCount() = tabs.size

        override fun getItem(position: Int) = newBooksFragment(position)

        override fun getPageTitle(position: Int): CharSequence = tabs[position]
    }

    class BooksFragment : Fragment() {
        private val books: ArrayList<Book> = ArrayList<Book>()
        private var headerText: String? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            var currentTab = arguments?.getInt("tab_index")
            if (currentTab == TAB_NEW) {
                books.addAll(Database.NEW_BOOKS)
                headerText = "NEW BOOKS"
            } else if (currentTab == TAB_ALL) {
                books.addAll(Database.ALL_BOOKS)
                headerText = "ALL BOOKS"
            }
        }

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
            val view: View = inflater.inflate(R.layout.fragment_books, container, false)
            val listView = view.findViewById<View>(R.id.list) as ListView
            listView.adapter = BooksAdapter(books)
            listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                    val book: Book = parent.getItemAtPosition(position) as Book
                    val intent = Intent(activity, BookDetailsActivity::class.java)
                    intent.putExtra(BookDetailsActivity.TITLE, book.title)
                    intent.putExtra(BookDetailsActivity.AUTHOR, book.author)
                    startActivity(intent)
                }
            val headerTextView: TextView = view.findViewById<View>(R.id.header_text) as TextView
            headerTextView.setText(headerText)
            return view
        }

        companion object {
            private const val TAB_NEW = 0
            private const val TAB_ALL = 1
        }
    }
}