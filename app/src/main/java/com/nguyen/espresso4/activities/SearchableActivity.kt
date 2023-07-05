package com.nguyen.espresso4.activities

import android.R
import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.provider.SearchRecentSuggestions
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.nguyen.espresso4.Database
import com.nguyen.espresso4.databinding.ActivitySearchableBinding
import com.nguyen.espresso4.provider.AppRecentSearchesProvider
import java.util.Locale

class SearchableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySearchableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // binding.list.emptyView = findViewById(R.id.empty_view)
        val intent: Intent = getIntent()
        if (Intent.ACTION_SEARCH == intent.getAction()) {
            val query = intent.getStringExtra(SearchManager.QUERY) as String
            val results = search(query)
            binding.list.adapter = ArrayAdapter<Any?>(this, R.layout.simple_list_item_1, results)
            saveRecentQuery(query)
        }
    }

    private fun saveRecentQuery(query: String) {
        val suggestions = SearchRecentSuggestions(
            this,
            AppRecentSearchesProvider.AUTHORITY,
            AppRecentSearchesProvider.MODE
        )
        suggestions.saveRecentQuery(query, null)
    }

    private fun search(query: String): List<String> {
        val results: MutableList<String> = ArrayList()
        for (record in Database.CITIES) {
            if (record.lowercase(Locale.getDefault())
                    .startsWith(query.lowercase(Locale.getDefault()))) {
                results.add(record)
            }
        }
        return results
    }
}