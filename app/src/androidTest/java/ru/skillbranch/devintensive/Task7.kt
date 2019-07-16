package ru.skillbranch.devintensive

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import ru.skillbranch.devintensive.extensions.isKeyboardClosed
import ru.skillbranch.devintensive.extensions.isKeyboardOpen

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