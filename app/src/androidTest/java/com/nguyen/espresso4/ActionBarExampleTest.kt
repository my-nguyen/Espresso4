package com.nguyen.espresso4

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.nguyen.espresso4.activities.ActionBarExampleActivity

//import android.test.ActivityInstrumentationTestCase2;
/**
 * @author vgrec, created on 3/20/15.
 */
class ActionBarExampleTest : ActivityTestRule<ActionBarExampleActivity>(ActionBarExampleActivity::class.java) {
    /*@Throws(Exception::class)
    override fun setUp() {
        super.setUp()
        activity
    }*/

    fun testClickOnMenuItem() {
        // Click on an item from ActionBar
        onView(withId(R.id.action_settings)).perform(click())

        // Verify the correct item was clicked by checking the content of the status TextView
        onView(withId(R.id.status)).check(matches(withText("Settings")))
    }

    fun testOverflowMenuOrOptionsMenu() {
        // Open the action bar overflow or options menu (depending if the device has or not a hardware menu button.)
        openActionBarOverflowOrOptionsMenu(activity)

        // Find the menu item with text "About" and click on it
        onView(withText("About")).perform(click())

        // Verify the correct item was clicked by checking the content of the status TextView
        onView(withId(R.id.status)).check(matches(withText("About")))
    }

    fun testActionMode() {
        // Show the contextual ActionBar
        onView(withId(R.id.toggle_action_mode)).perform(click())

        // Click on a context item
        onView(withId(R.id.action_one)).perform(click())

        // Verify the correct item was clicked by checking the content of the status TextView
        onView(withId(R.id.status)).check(matches(withText("ActionMode1")))
    }
}