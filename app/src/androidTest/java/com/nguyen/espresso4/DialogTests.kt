package com.nguyen.espresso4

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.nguyen.espresso4.activities.DialogExampleActivity

/**
 * @author vgrec, created on 3/24/15.
 */
class DialogTests : ActivityTestRule<DialogExampleActivity>(DialogExampleActivity::class.java) {
    /*@Throws(Exception::class)
    protected fun setUp() {
        super.setUp()
        getActivity()
    }*/

    fun testCheckDialogDisplayed() {
        // Click on the button that shows the dialog
        onView(withId(R.id.confirm_dialog_button)).perform(click())

        // Check the dialog title text is displayed
        onView(withText(R.string.dialog_title)).check(matches(isDisplayed()))
    }

    fun testClickOkButton() {
        onView(withId(R.id.confirm_dialog_button)).perform(click())

        // android.R.id.button1 = positive button
        onView(withId(android.R.id.button1)).perform(click())
        onView(withId(R.id.status_text)).check(matches(withText(R.string.ok)))
    }

    fun testClickCancelButton() {
        onView(withId(R.id.confirm_dialog_button)).perform(click())

        // android.R.id.button2 = negative button
        onView(withId(android.R.id.button2)).perform(click())
        onView(withId(R.id.status_text)).check(matches(withText(R.string.cancel)))
    }
}