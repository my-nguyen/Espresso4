package com.nguyen.espresso4

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.nguyen.espresso4.activities.EnterNameActivity
import org.hamcrest.CoreMatchers.not

/**
 * @author vgrec, created on 3/17/15.
 */
class EnterNameTest : ActivityTestRule<EnterNameActivity>(EnterNameActivity::class.java) {
    /*@Throws(Exception::class)
    protected fun setUp() {
        super.setUp()
        getActivity()
    }*/

    fun testHintDisplayed() {
        onView(withId(R.id.name_edittext)).check(matches(withHint(R.string.enter_name)))
    }

    fun testErrorMessageDisplayed() {
        // Making sure the error message is not displayed by default
        onView(withId(R.id.error_text)).check(matches(not(isDisplayed())))

        // Click on "Next" button
        onView(withId(R.id.next_button)).perform(click())

        // Now check the error message is displayed
        onView(withId(R.id.error_text)).check(matches(isDisplayed()))
    }

    fun testGreetingMessageWithNameDisplayed() {
        onView(withId(R.id.name_edittext)).perform(typeText(USER_NAME))
        onView(withId(R.id.next_button)).perform(click())
        onView(withId(R.id.greeting_message)).check(matches(withText(GREETING_MESSAGE)))
    }

    companion object {
        const val USER_NAME = "John"
        const val GREETING_MESSAGE = "Hello " + USER_NAME + "!"
    }
}