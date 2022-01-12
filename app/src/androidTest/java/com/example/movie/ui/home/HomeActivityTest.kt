package com.example.movie.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.movie.R
import com.example.movie.utils.DataDummy
import com.example.movie.utils.EspressoIdlingResources
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest{
    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyShows = DataDummy.generateDummyShows()

    @Before
    fun setUp(){
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }


    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovie(){
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.text_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.text_duration)).check(matches(withText(dummyMovies[0].duration)))
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(withText(dummyMovies[0].description)))
    }

    @Test
    fun loadShow(){
        onView(withId(R.id.view_pager)).perform(swipeLeft())
        onView(withId(R.id.rv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyShows.size))
    }

    @Test
    fun loadDetailShow(){
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyShows[0].title)))
        onView(withId(R.id.text_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.text_duration)).check(matches(withText(dummyShows[0].duration)))
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(withText(dummyShows[0].description)))
    }

    @Test
    fun loadLiked(){
        onView(withId(R.id.liked_list)).perform(click())
    }

    @Test
    fun likeUnlikeMovie(){
        //like a movie
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        onView(withId(R.id.action_like)).perform(click())

        //view liked movie
        onView(withId(R.id.detail_content)).perform(pressBack())
        onView(withId(R.id.liked_list)).perform(click())

        //unlike a movie
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        onView(withId(R.id.action_like)).perform(click())
    }

    @Test
    fun likeUnlikeShow(){
        //like a show
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        onView(withId(R.id.action_like)).perform(click())

        //view liked show
        onView(withId(R.id.detail_content)).perform(pressBack())
        onView(withId(R.id.liked_list)).perform(click())
        onView(withText("TV SHOWS")).perform(click())

        //unlike a show
        onView(withId(R.id.rv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        onView(withId(R.id.action_like)).perform(click())
    }

}