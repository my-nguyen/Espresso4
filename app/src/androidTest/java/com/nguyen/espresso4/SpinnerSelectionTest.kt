package com.nguyen.espresso4

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.nguyen.espresso4.activities.SpinnerSelectionActivity
import com.nguyen.espresso4.matchers.CustomMatchers.withAdaptedData
import com.nguyen.espresso4.matchers.CustomMatchers.withItemContent
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matchers

/**
 * @author vgrec, created on 3/17/15.
 */
class SpinnerSelectionTest : ActivityTestRule<SpinnerSelectionActivity>(SpinnerSelectionActivity::class.java) {
    /*@Throws(Exception::class)
    protected fun setUp() {
        super.setUp()
        getActivity()
    }*/

    fun testCountryNotInList() {
        onView(withId(R.id.countries_spinner)).check(
            matches(not(withAdaptedData(withItemContent(INVALID_COUNTRY_NAME))))
        )
    }

    fun testLabelDoesNotChangeIfFirstItemSelected() {
        // Click on the Spinner
        onView(withId(R.id.countries_spinner)).perform(click())

        // Click on the first item from the list, which is a marker string: "Select your country"
        onData(Matchers.allOf(CoreMatchers.`is`(Matchers.instanceOf(String::class.java)))).atPosition(
            0
        ).perform(click())

        // Check that the country label is not updated.
        onView(withId(R.id.country_label)).check(matches(not(withText(FIRST_ITEM_TEXT))))
    }

    fun testLabelUpdatesIfValidCountrySelected() {
        // Click on the Spinner
        onView(withId(R.id.countries_spinner)).perform(click())

        // Select a country from the list
        onData(
            Matchers.allOf(
                CoreMatchers.`is`(Matchers.instanceOf(String::class.java)), CoreMatchers.`is`(VALID_COUNTRY_NAME)
            )
        ).perform(click())

        // Check that the country label is updated with selected country
        onView(withId(R.id.country_label)).check(matches(withText(VALID_COUNTRY_NAME)))
    }

    companion object {
        const val INVALID_COUNTRY_NAME = "NoSuchCountry"
        const val VALID_COUNTRY_NAME = "Moldova"
        const val FIRST_ITEM_TEXT = "Select your country"
    }
}