package com.nguyen.espresso4.provider

import android.content.SearchRecentSuggestionsProvider

/**
 * @author vgrec, created on 3/18/15.
 */
class AppRecentSearchesProvider : SearchRecentSuggestionsProvider() {
    init {
        setupSuggestions(AUTHORITY, MODE)
    }

    companion object {
        const val AUTHORITY = "com.vgrec.espressoexamples"
        const val MODE = DATABASE_MODE_QUERIES
    }
}