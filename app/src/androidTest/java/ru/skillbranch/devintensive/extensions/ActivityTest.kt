package ru.skillbranch.devintensive.extensions

import android.graphics.Rect
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.skillbranch.devintensive.MainActivity


@RunWith(AndroidJUnit4::class)
class ActivityTest {
    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun hideKeyboardTest(){
        onView(withId(rule.activity.messageEt.id)).perform(typeText("something"))
        Thread.sleep(2000)
        var rootView = rule.activity.findViewById<View>(android.R.id.content)
        var visibleBounds = Rect()
        rootView.getWindowVisibleDisplayFrame(visibleBounds)
        val openKeyboardHeight = rootView.height - visibleBounds.height()

        rule.activity.hideKeyboard()

        Thread.sleep(2000)
        rootView.getWindowVisibleDisplayFrame(visibleBounds)
        val closedKeyboardHeight = rootView.height - visibleBounds.height()

        assertTrue(openKeyboardHeight > closedKeyboardHeight)
    }

    @Test
    fun isKeyboardClosedTest(){
        Thread.sleep(2000)
        assertTrue(rule.activity.isKeyboardClosed())
    }

    @Test
    fun isKeyboardOpenTest(){
        onView(withId(rule.activity.messageEt.id)).perform(typeText("something"))
        Thread.sleep(2000)
        assertTrue(rule.activity.isKeyboardOpen())
    }
}