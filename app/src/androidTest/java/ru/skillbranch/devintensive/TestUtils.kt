package ru.skillbranch.devintensive

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import ru.skillbranch.devintensive.ui.profile.ProfileActivity

fun rotateScreen(activity: Activity, isLandscape: Boolean){
    InstrumentationRegistry.getInstrumentation().runOnMainSync {
        activity.requestedOrientation = if (isLandscape) ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE else ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
    InstrumentationRegistry.getInstrumentation().waitForIdleSync()
    Thread.sleep(2000)
}