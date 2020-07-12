package com.cep96.padc_x_travel_assignment_cep.uitests.tourlist

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.cep96.padc_x_travel_assignment_cep.R
import com.cep96.padc_x_travel_assignment_cep.activities.MainActivity
import com.cep96.padc_x_travel_assignment_cep.views.viewholders.CountryViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class GoToTourDetails {

    private val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp(){
        activityTestRule.launchActivity(Intent())
        activityTestRule.activity.supportFragmentManager.beginTransaction()
    }

    @Test
    fun tapOnTour_navigateToTourDetails(){
        onView(withId(R.id.rvPopularTours))
            .perform(RecyclerViewActions.actionOnItemAtPosition<CountryViewHolder>(0, click()))

        onView(withId(R.id.ivPopularTour))
            .check(matches(isDisplayed()))

    }

}