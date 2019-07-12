package ru.skillbranch.devintensive.activity

import android.R
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.widget.EditText
import org.hamcrest.Matchers.endsWith
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.skillbranch.devintensive.MainActivity
import ru.skillbranch.devintensive.findEditTextView
import ru.skillbranch.devintensive.rotateScreen

@RunWith(AndroidJUnit4::class)
class SaveStateOnRecreateTest {
    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun rotateWithoutIdTest(){
        val editText = findEditTextView(rule.activity.findViewById(R.id.content))
        assertNotNull(editText)
        onView(ViewMatchers.withClassName(endsWith("EditText"))).perform(typeText("to not disappear!"))
        rotateScreen(rule.activity, true)

        var newEditView = findEditTextView(rule.activity.findViewById(R.id.content))
        assertEquals("to not disappear!", newEditView?.text.toString())
        rotateScreen(rule.activity, false)

        newEditView = findEditTextView(rule.activity.findViewById(R.id.content))
        assertEquals("to not disappear!", newEditView?.text.toString())
    }

    @Test
    fun textFieldHasId(){
        val correctIdName = "et_message"
        val normId = rule.activity.resources.getIdentifier(correctIdName, "id", rule.activity.packageName)
        val view = rule.activity.findViewById<View>(normId)
        assertTrue(view is EditText)
    }

    @Test
    fun listenAnswerState(){
        assertEquals("Как меня зовут?", rule.activity.textView.text)
        onView(withId(rule.activity.messageEt.id)).perform(typeText("Bender"))
        onView(withId(rule.activity.sendBtn.id)).perform(click())
        assertEquals("Отлично - ты справился\nНазови мою профессию?", rule.activity.textView.text)
        rotateScreen(rule.activity, true)
        assertEquals("Назови мою профессию?", rule.activity.textView.text)
        rotateScreen(rule.activity, false)
        assertEquals("Назови мою профессию?", rule.activity.textView.text)
        onView(withId(rule.activity.messageEt.id)).perform(typeText("bender"))
        onView(withId(rule.activity.sendBtn.id)).perform(click())
        assertEquals("Отлично - ты справился\nИз чего я сделан?", rule.activity.textView.text)
    }
}