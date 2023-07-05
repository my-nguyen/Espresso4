package com.nguyen.espresso4

import android.widget.AdapterView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.nguyen.espresso4.activities.ViewPagerActivity
import com.nguyen.espresso4.matchers.CustomMatchers.withBookAuthor
import com.nguyen.espresso4.matchers.CustomMatchers.withBookTitle
import org.hamcrest.CoreMatchers

/**
 * @author vgrec, created on 3/23/15.
 */
class ViewPagerTest : ActivityTestRule<ViewPagerActivity>(ViewPagerActivity::class.java) {
    /*@Throws(Exception::class)
    protected fun setUp() {
        super.setUp()
        getActivity()
    }*/

    fun testAllTabDisplayedOnSwipe() {
        // Locate the ViewPager and perform a swipe left action
        onView(withId(R.id.pager)).perform(swipeLeft())

        // Check the "ALL BOOKS" text is displayed
        onView(
            CoreMatchers.allOf(
                withId(R.id.header_text),
                isDisplayed()
            )
        ).check(matches(withText("ALL BOOKS")))
    }

    fun testClickOnBookFromNewTab() {
        // The below commented out line will fail with AmbiguousViewMatcherException because the same ListView is used in both pages of ViewPager.
        // onData(allOf(withBookTitle(BOOK_TITLE), withBookAuthor(BOOK_AUTHOR))).perform(click());

        // We have to refine the query specifying that we are looking for an AdapterView that is currently visible.
        onData(CoreMatchers.allOf(withBookTitle(BOOK_TITLE), withBookAuthor(BOOK_AUTHOR)))
            .inAdapterView(
                CoreMatchers.allOf(
                    isAssignableFrom(AdapterView::class.java),
                    isDisplayed()
                )
            )
            .perform(click())

        // Check the correct book title is displayed
        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)))

        // Check the correct author is displayed
        onView(withId(R.id.book_author)).check(matches(withText(BOOK_AUTHOR)))
    }

    companion object {
        private const val BOOK_TITLE = "Clean Code"
        private const val BOOK_AUTHOR = "Robert C. Martin"
    }
}