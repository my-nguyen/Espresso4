package com.nguyen.espresso4

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.nguyen.espresso4.activities.CustomListActivity
import com.nguyen.espresso4.matchers.CustomMatchers.withBookAuthor
import com.nguyen.espresso4.matchers.CustomMatchers.withBookId
import com.nguyen.espresso4.matchers.CustomMatchers.withBookTitle
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.allOf

/**
 * @author vgrec, created on 3/18/15.
 */
class CustomListTest : ActivityTestRule<CustomListActivity>(CustomListActivity::class.java) {
    /*@Throws(Exception::class)
    protected fun setUp() {
        super.setUp()
        getActivity()
    }*/

    fun testOpenBookById() {
        // Click on the Book with ID 5
        onData(withBookId(5)).perform(click())

        // Check the correct book title is displayed
        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)))

        // Check the correct author is displayed
        onView(withId(R.id.book_author)).check(matches(withText(BOOK_AUTHOR)))
    }

    fun testOpenBookByTitleAndAuthor() {
        // Match a book with a specific title and author name
        onData(allOf(withBookTitle(BOOK_TITLE), withBookAuthor(BOOK_AUTHOR))).perform(click())

        // Check the correct book title is displayed
        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)))

        // Check the correct author is displayed
        onView(withId(R.id.book_author)).check(matches(withText(BOOK_AUTHOR)))
    }

    fun testClickOnBookByPosition() {
        onData(CoreMatchers.anything()).atPosition(5).perform(click())
        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)))
        onView(withId(R.id.book_author)).check(matches(withText(BOOK_AUTHOR)))
    }

    companion object {
        private const val BOOK_TITLE = "Java Concurrency in Practice"
        private const val BOOK_AUTHOR = "Brian Goetz"
    }
}