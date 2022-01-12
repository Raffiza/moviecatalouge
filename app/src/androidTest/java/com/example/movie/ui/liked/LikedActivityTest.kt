package com.example.movie.ui.liked

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.movie.R
import com.example.movie.utils.EspressoIdlingResources
import org.junit.After
import org.junit.Test

import org.junit.Before

class LikedActivityTest {

    @Before
    fun setUp(){
        ActivityScenario.launch(LikedActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }

    @Test
    fun loadAllLikedMovies(){
        onView(withId(R.id.rv_movie)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))
    }

    @Test
    fun loadAllLikedShow(){
        onView(withId(R.id.view_pager)).perform(swipeLeft())
        onView(withId(R.id.rv_show)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))
    }
}