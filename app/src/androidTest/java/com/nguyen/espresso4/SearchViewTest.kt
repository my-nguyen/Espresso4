package com.nguyen.espresso4

import android.widget.EditText
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressImeActionButton
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.nguyen.espresso4.activities.SearchViewActivity
import com.nguyen.espresso4.matchers.CustomMatchers.withItemContent
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matchers

/**
 * @author vgrec, created on 3/19/15.
 */
class SearchViewTest : ActivityTestRule<SearchViewActivity>(SearchViewActivity::class.java) {
    /*@Throws(Exception::class)
    protected fun setUp() {
        super.setUp()
        getActivity()
    }*/

    fun testItemNotFound() {
        // Click on the search icon
        onView(withId(R.id.action_search)).perform(click())

        // Type the text in the search field and submit the query
        onView(isAssignableFrom(EditText::class.java)).perform(
            typeText("No such item"),
            pressImeActionButton()
        )

        // Check the empty view is displayed
        onView(withId(R.id.empty_view)).check(matches(isDisplayed()))
    }

    fun testItemFound() {
        onView(withId(R.id.action_search)).perform(click())
        onView(isAssignableFrom(EditText::class.java)).perform(
            typeText(HELSINKI),
            pressImeActionButton()
        )

        // Check empty view is not displayed
        onView(withId(R.id.empty_view)).check(matches(not(isDisplayed())))

        // Check the item we are looking for is in the search result list.
        onData(
            allOf(
                CoreMatchers.`is`(Matchers.instanceOf(String::class.java)), withItemContent(
                    HELSINKI
                )
            )
        ).check(matches(isDisplayed()))
    }

    fun testSearchSuggestionDisplayed() {
        onView(withId(R.id.action_search)).perform(click())
        onView(isAssignableFrom(EditText::class.java)).perform(
            typeText(HELSINKI),
            pressImeActionButton()
        )

        // Go back to previous screen
        pressBack()

        // Clear the text in search field
        onView(isAssignableFrom(EditText::class.java)).perform(clearText())

        // Enter the first letter of the previously searched word
        onView(isAssignableFrom(EditText::class.java)).perform(typeText("He"))

        // Check the search suggestions appear
        onView(withText(HELSINKI))
            .inRoot(withDecorView(not(Matchers.`is`(getActivity().getWindow().getDecorView()))))
            .check(matches(isDisplayed()))
    }

    fun testClickOnSearchSuggestion() {
        onView(withId(R.id.action_search)).perform(click())
        onView(isAssignableFrom(EditText::class.java)).perform(
            typeText(HELSINKI),
            pressImeActionButton()
        )

        // Go back to previous screen
        pressBack()

        // Clear the text in search field
        onView(isAssignableFrom(EditText::class.java)).perform(clearText())

        // Enter the first letter of the previously searched word
        onView(isAssignableFrom(EditText::class.java)).perform(typeText("He"))


        // Click on the "Java" item from the suggestions list
        onView(withText(HELSINKI))
            .inRoot(withDecorView(not(Matchers.`is`(getActivity().getWindow().getDecorView()))))
            .perform(click())

        // Check the item appears in search results list.
        onData(
            allOf(
                CoreMatchers.`is`(Matchers.instanceOf(String::class.java)), withItemContent(
                    HELSINKI
                )
            )
        ).check(matches(isDisplayed()))
    }

    companion object {
        const val HELSINKI = "Helsinki"
    }
}