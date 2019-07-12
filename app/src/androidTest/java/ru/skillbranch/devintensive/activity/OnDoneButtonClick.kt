package ru.skillbranch.devintensive.activity

import android.graphics.Rect
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.pressImeActionButton
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.skillbranch.devintensive.MainActivity

@RunWith(AndroidJUnit4::class)
class OnDoneButtonClick {
    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun hideKeyboardOnDoneBtnTest(){
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("Bender"))
        Thread.sleep(2000)

        var rootView = rule.activity.findViewById<View>(android.R.id.content)
        var visibleBounds = Rect()
        rootView.getWindowVisibleDisplayFrame(visibleBounds)
        val openKeyboardHeight = rootView.height - visibleBounds.height()

        onView(withId(rule.activity.messageEt.id)).perform(pressImeActionButton())

        Thread.sleep(2000)
        rootView.getWindowVisibleDisplayFrame(visibleBounds)
        val closedKeyboardHeight = rootView.height - visibleBounds.height()

        assertTrue(openKeyboardHeight > closedKeyboardHeight)
        assertTrue(rule.activity.messageEt.text.isEmpty())
        assertEquals("Отлично - ты справился\nНазови мою профессию?", rule.activity.textView.text)
    }
}