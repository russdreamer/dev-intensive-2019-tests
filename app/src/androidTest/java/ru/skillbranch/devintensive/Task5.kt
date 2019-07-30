package ru.skillbranch.devintensive

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.skillbranch.devintensive.ui.profile.ProfileActivity

@RunWith(AndroidJUnit4::class)
class Task5 {
    @Rule
    @JvmField
    val rule = ActivityTestRule(ProfileActivity::class.java)

    @Test
    fun splashScreenTest(){
        val loaderTheme = rule.activity.packageManager.getActivityInfo(rule.activity.componentName, 0).themeResource
        assertEquals(R.style.SplashTheme, loaderTheme)

        val clazz = ProfileActivity::class.java
        val method = clazz.getMethod("getThemeResId")
        method.isAccessible = true
        val activityThemeResId = method.invoke(rule.activity) as Int
        assertEquals(R.style.AppTheme, activityThemeResId)
    }
}