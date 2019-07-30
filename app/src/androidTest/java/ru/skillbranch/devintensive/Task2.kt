package ru.skillbranch.devintensive

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.skillbranch.devintensive.ui.profile.ProfileActivity

@RunWith(AndroidJUnit4::class)
class Task2 {
    @Rule
    @JvmField
    val rule = ActivityTestRule(ProfileActivity::class.java)

    @Test
    fun saveInfoTest(){
        val editBtnId = rule.activity.resources.getIdentifier("btn_edit", "id", rule.activity.packageName)
        clearInfo()
        Espresso.onView(ViewMatchers.withId(editBtnId)).perform(ViewActions.click())
        fillInfo()
        checkInfo()
        Espresso.onView(ViewMatchers.withId(editBtnId)).perform(ViewActions.click())
        checkInfo()
    }

    @Test
    fun saveInfoRotateTest(){
        val editBtnId = rule.activity.resources.getIdentifier("btn_edit", "id", rule.activity.packageName)
        clearInfo()
        Espresso.onView(ViewMatchers.withId(editBtnId)).perform(ViewActions.click())
        fillInfo()
        Espresso.onView(ViewMatchers.withId(editBtnId)).perform(ViewActions.click())
        rotateScreen(rule.activity, true)
        rotateScreen(rule.activity, false)
        checkInfo()
    }

    @Test
    fun editableOnRotateTest(){
        val editBtnId = rule.activity.resources.getIdentifier("btn_edit", "id", rule.activity.packageName)
        clearInfo()
        Espresso.onView(ViewMatchers.withId(editBtnId)).perform(ViewActions.click())
        rotateScreen(rule.activity, true)
        rotateScreen(rule.activity, false)
        fillInfo()
        Espresso.onView(ViewMatchers.withId(editBtnId)).perform(ViewActions.click())
        checkInfo()
    }

    @Test
    fun saveOnExitTest(){
        val editBtnId = rule.activity.resources.getIdentifier("btn_edit", "id", rule.activity.packageName)
        clearInfo()
        Espresso.onView(ViewMatchers.withId(editBtnId)).perform(ViewActions.click())
        fillInfo()
        Espresso.onView(ViewMatchers.withId(editBtnId)).perform(ViewActions.click())
        val intent = rule.activity.intent
        rule.finishActivity()
        Thread.sleep(1000)
        rule.launchActivity(intent)
        Thread.sleep(1000)
        checkInfo()
    }

    @Test
    fun saveAfterRotate(){
        val editBtnId = rule.activity.resources.getIdentifier("btn_edit", "id", rule.activity.packageName)
        clearInfo()
        Espresso.onView(ViewMatchers.withId(editBtnId)).perform(ViewActions.click())
        fillInfo()
        rotateScreen(rule.activity, true)
        Espresso.onView(ViewMatchers.withId(editBtnId)).perform(ViewActions.click())
        checkInfo()
    }

    private fun checkInfo() {
        val firstNameId = rule.activity.resources.getIdentifier("et_first_name", "id", rule.activity.packageName)
        Espresso.onView(ViewMatchers.withId(firstNameId)).check(matches(withText("Anton")))

        val lastNameId = rule.activity.resources.getIdentifier("et_last_name", "id", rule.activity.packageName)
        Espresso.onView(ViewMatchers.withId(lastNameId)).check(matches(withText("Karton")))

        val aboutId = rule.activity.resources.getIdentifier("et_about", "id", rule.activity.packageName)
        Espresso.onView(ViewMatchers.withId(aboutId)).check(matches(withText("1\n2\n3")))

        val repoId = rule.activity.resources.getIdentifier("et_repository", "id", rule.activity.packageName)
        Espresso.onView(ViewMatchers.withId(repoId)).check(matches(withText("github.com/bender")))
    }

    private fun fillInfo() {
        val firstNameId = rule.activity.resources.getIdentifier("et_first_name", "id", rule.activity.packageName)
        Espresso.onView(ViewMatchers.withId(firstNameId)).perform(ViewActions.typeText("Anton"))
        Espresso.onView(ViewMatchers.withId(firstNameId)).perform(ViewActions.closeSoftKeyboard())

        val lastNameId = rule.activity.resources.getIdentifier("et_last_name", "id", rule.activity.packageName)
        Espresso.onView(ViewMatchers.withId(lastNameId)).perform(ViewActions.typeText("Karton"))
        Espresso.onView(ViewMatchers.withId(lastNameId)).perform(ViewActions.closeSoftKeyboard())

        val aboutId = rule.activity.resources.getIdentifier("et_about", "id", rule.activity.packageName)
        Espresso.onView(ViewMatchers.withId(aboutId)).perform(ViewActions.typeText("1\n2\n3"))
        Espresso.onView(ViewMatchers.withId(aboutId)).perform(ViewActions.closeSoftKeyboard())

        val repoId = rule.activity.resources.getIdentifier("et_repository", "id", rule.activity.packageName)
        Espresso.onView(ViewMatchers.withId(repoId)).perform(ViewActions.typeText("github.com/bender"))
        Espresso.onView(ViewMatchers.withId(repoId)).perform(ViewActions.closeSoftKeyboard())
    }

    private fun clearInfo() {
        val firstNameId = rule.activity.resources.getIdentifier("et_first_name", "id", rule.activity.packageName)
        Espresso.onView(ViewMatchers.withId(firstNameId)).perform(ViewActions.replaceText(""))

        val lastNameId = rule.activity.resources.getIdentifier("et_last_name", "id", rule.activity.packageName)
        Espresso.onView(ViewMatchers.withId(lastNameId)).perform(ViewActions.replaceText(""))

        val aboutId = rule.activity.resources.getIdentifier("et_about", "id", rule.activity.packageName)
        Espresso.onView(ViewMatchers.withId(aboutId)).perform(ViewActions.replaceText(""))

        val repoId = rule.activity.resources.getIdentifier("et_repository", "id", rule.activity.packageName)
        Espresso.onView(ViewMatchers.withId(repoId)).perform(ViewActions.replaceText(""))
    }
}