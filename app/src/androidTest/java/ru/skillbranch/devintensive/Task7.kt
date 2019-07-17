package ru.skillbranch.devintensive

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.skillbranch.devintensive.extensions.isKeyboardClosed
import ru.skillbranch.devintensive.extensions.isKeyboardOpen

@RunWith(AndroidJUnit4::class)
class Task7 {
    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun isKeyboardClosedTestPortrait() {
        Thread.sleep(2000)
        assertTrue(rule.activity.isKeyboardClosed())
    }

    @Test
    fun isKeyboardClosedTestLandscape() {
        rotateScreen(rule.activity, true)
        Thread.sleep(2000)
        assertTrue(rule.activity.isKeyboardClosed())
        rotateScreen(rule.activity, false)
    }

    @Test
    fun isKeyboardOpenTestPortrait() {
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("something"))
        Thread.sleep(2000)
        assertTrue(rule.activity.isKeyboardOpen())
    }

    @Test
    fun isKeyboardOpenTestLandscape() {
        rotateScreen(rule.activity, true)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
            .perform(ViewActions.typeText("something in landscape"))
        Thread.sleep(2000)
        assertTrue(rule.activity.isKeyboardOpen())
        rotateScreen(rule.activity, false)
    }
}