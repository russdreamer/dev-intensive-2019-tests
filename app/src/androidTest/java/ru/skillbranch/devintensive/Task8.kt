package ru.skillbranch.devintensive

import android.content.res.Configuration
import android.graphics.Color
import android.support.v7.graphics.Palette
import androidx.core.graphics.drawable.toBitmap
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.skillbranch.devintensive.ui.custom.CircleImageView
import ru.skillbranch.devintensive.ui.profile.ProfileActivity

@RunWith(AndroidJUnit4::class)
class Task8 {
    @Rule
    @JvmField
    val rule = ActivityTestRule(ProfileActivity::class.java)

    var editBtnId: Int? = null
    var firstNameId: Int? = null
    var lastNameId: Int? = null
    var avaId: Int? = null
    var ava: CircleImageView? = null

    @Test
    fun circleImageViewTest(){
        updateFields()
        Espresso.onView(ViewMatchers.withId(editBtnId!!)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(firstNameId!!)).perform(ViewActions.replaceText("Anton"))
        Espresso.onView(ViewMatchers.withId(lastNameId!!)).perform(ViewActions.replaceText("Karton"))
        Espresso.onView(ViewMatchers.withId(editBtnId!!)).perform(ViewActions.click())

        val curTheme = rule.activity.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        if (curTheme == Configuration.UI_MODE_NIGHT_YES) {
            switchTheme()
            updateFields()
        }

        var palette = Palette.from(ava!!.drawable.toBitmap()).generate()
        var color = palette.getDominantColor(0)
        assertEquals(-505784, color)
        switchTheme()
        updateFields()

        palette = Palette.from(ava!!.drawable.toBitmap()).generate()
        color = palette.getDominantColor(0)
        assertEquals(-14642960, color)

        rule.activity.runOnUiThread {
            assertEquals(2, ava!!.getBorderWidth())
            assertEquals(Color.WHITE, ava!!.getBorderColor())
            ava!!.setBorderColor(R.color.color_gray_dark)
            ava!!.setBorderWidth(20)

            color = rule.activity.resources.getColor(R.color.color_gray_dark, rule.activity.theme)
            assertEquals(color, ava!!.getBorderColor())
            assertEquals(20, ava!!.getBorderWidth())

            ava!!.setBorderColor("#1ab33e")
            assertEquals(-15027394, ava!!.getBorderColor())
        }
    }

    private fun switchTheme() {
        val switchThemeBtnId = rule.activity.resources.getIdentifier("btn_switch_theme", "id", rule.activity.packageName)
        Espresso.onView(ViewMatchers.withId(switchThemeBtnId)).perform(ViewActions.click())
    }

    private fun updateFields(){
        editBtnId = rule.activity.resources.getIdentifier("btn_edit", "id", rule.activity.packageName)
        firstNameId = rule.activity.resources.getIdentifier("et_first_name", "id", rule.activity.packageName)
        lastNameId = rule.activity.resources.getIdentifier("et_last_name", "id", rule.activity.packageName)
        avaId = rule.activity.resources.getIdentifier("iv_avatar", "id", rule.activity.packageName)
        ava = rule.activity.findViewById<CircleImageView>(avaId!!)
    }
}
