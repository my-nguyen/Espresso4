package com.nguyen.espresso4

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.nguyen.espresso4.activities.RecyclerViewActivity

/**
 * @author vgrec, created on 3/30/15.
 */
class RecyclerViewTest : ActivityTestRule<RecyclerViewActivity>(RecyclerViewActivity::class.java) {
    /*@Throws(Exception::class)
    protected fun setUp() {
        super.setUp()
        getActivity()
    }*/

    fun testClickAtPosition() {
        // Perform a click on first element in the RecyclerView
        onView(withId(R.id.recyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)))
        onView(withId(R.id.book_author)).check(matches(withText(BOOK_AUTHOR)))
    }

    fun testClickOnViewInRow() {
        // Perform click on an element with a specific text
        onView(withId(R.id.recyclerView)).perform(
            RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                hasDescendant(withText(BOOK_TITLE)), click()
            )
        )
        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)))
    }

    companion object {
        private const val BOOK_TITLE = "Clean Code"
        private const val BOOK_AUTHOR = "Robert C. Martin"
    }
}