package ru.skillbranch.devintensive

import android.content.res.Configuration
import android.graphics.Color
import android.util.TypedValue
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.skillbranch.devintensive.ui.profile.ProfileActivity

@RunWith(AndroidJUnit4::class)
class Task3 {
    @Rule
    @JvmField
    val rule = ActivityTestRule(ProfileActivity::class.java)

    @Test
    fun checkDayThemeColorsTest(){
        var curTheme = rule.activity.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        if (curTheme == Configuration.UI_MODE_NIGHT_YES)
            switchTheme()

        curTheme = rule.activity.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        assertEquals(curTheme, Configuration.UI_MODE_NIGHT_NO)

        checkColors("#473770", "#9CA9BA", "#1F000000")
    }

    @Test
    fun checkNightThemeColorsTest(){
        var curTheme = rule.activity.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        if (curTheme == Configuration.UI_MODE_NIGHT_NO)
            switchTheme()

        curTheme = rule.activity.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        assertEquals(curTheme, Configuration.UI_MODE_NIGHT_YES)

        checkColors("#1FFFFFFF", "#ffffffff", "#1F000000")
    }

    @Test
    fun saveThemeOnExitTest(){
        val prevTheme = rule.activity.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        switchTheme()

        val intent = rule.activity.intent
        rule.finishActivity()
        Thread.sleep(1000)
        rule.launchActivity(intent)
        Thread.sleep(1000)

        val newTheme = rule.activity.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        assertNotEquals(prevTheme, newTheme)
    }

    private fun checkColors(surface: String, icon: String, divider: String) {
        val typedValue = TypedValue()
        val colorAccentedSurface = rule.activity.resources.getIdentifier("colorAccentedSurface", "attr", rule.activity.packageName)
        rule.activity.theme.resolveAttribute(colorAccentedSurface, typedValue, true)
        var color = typedValue.data
        assertEquals(color, Color.parseColor(surface))

        val colorIcon = rule.activity.resources.getIdentifier("colorIcon", "attr", rule.activity.packageName)
        rule.activity.theme.resolveAttribute(colorIcon, typedValue, true)
        color = typedValue.data
        assertEquals(color, Color.parseColor(icon))

        val colorDivider = rule.activity.resources.getIdentifier("colorDivider", "attr", rule.activity.packageName)
        rule.activity.theme.resolveAttribute(colorDivider, typedValue, true)
        color = typedValue.data
        assertEquals(color, Color.parseColor(divider))
    }

    private fun switchTheme() {
        val switchThemeBtnId = rule.activity.resources.getIdentifier("btn_switch_theme", "id", rule.activity.packageName)
        Espresso.onView(ViewMatchers.withId(switchThemeBtnId)).perform(ViewActions.click())
    }
}