package com.nguyen.espresso4

import android.widget.DatePicker
import android.widget.TimePicker
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.PickerActions
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.nguyen.espresso4.activities.DateTimePickerActivity
import org.hamcrest.Matchers

/**
 * @author vgrec, created on 4/2/15.
 */
class DateTimePickerTest : ActivityTestRule<DateTimePickerActivity>(DateTimePickerActivity::class.java) {
    /*@Throws(Exception::class)
    protected fun setUp() {
        super.setUp()
        getActivity()
    }*/

    fun testSetDate() {
        val year = 2020
        val month = 11
        val day = 15
        onView(withId(R.id.date_picker_button)).perform(click())
        onView(withClassName(Matchers.equalTo(DatePicker::class.java.getName()))).perform(
            PickerActions.setDate(year, month + 1, day)
        )
        onView(withId(android.R.id.button1)).perform(click())
        onView(withId(R.id.status)).check(matches(withText("$year/$month/$day")))
    }

    fun testSetTime() {
        val hour = 10
        val minutes = 59
        onView(withId(R.id.time_picker_button)).perform(click())
        onView(withClassName(Matchers.equalTo(TimePicker::class.java.getName()))).perform(
            PickerActions.setTime(hour, minutes)
        )
        onView(withId(android.R.id.button1)).perform(click())
        onView(withId(R.id.status)).check(matches(withText("$hour:$minutes")))
    }
}