package com.example.testingfragmentsinisolation.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.testingfragmentsinisolation.R
import com.example.testingfragmentsinisolation.factory.MovieFragmentFactory
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
internal class DirectorsFragmentTest
{

    @Test
    fun testIsDirectorsListVisible()
    {
        val directors = arrayListOf("R.J. Stewart", "James Vanderbilt")
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putStringArrayList("args_directors" ,directors)
        launchFragmentInContainer<DirectorsFragment>(fragmentArgs = bundle , factory = fragmentFactory)

        onView(withId(R.id.directors_text)).check(matches(withText(DirectorsFragment.stringBuilderForDirectors(directors))))

    }
}