package com.changers.breeds

import com.changers.breeds.ui.MainActivity
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@Config(manifest=Config.NONE)
@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    private lateinit var activity: MainActivity

    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
    }

    @Test
    fun shouldNotBeNull() {
        assertNotNull(activity)
    }
}