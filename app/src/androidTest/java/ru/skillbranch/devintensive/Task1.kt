package ru.skillbranch.devintensive

import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.google.android.material.textfield.TextInputLayout
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.skillbranch.devintensive.ui.profile.ProfileActivity

@RunWith(AndroidJUnit4::class)
class Task1 {
    @Rule
    @JvmField
    val rule = ActivityTestRule(ProfileActivity::class.java)

    @Test
    fun projectStructureTest(){
        val editBtnId = rule.activity.resources.getIdentifier("btn_edit", "id", rule.activity.packageName)
        val editBtn = rule.activity.findViewById<View>(editBtnId)
        assertTrue(editBtn is ImageButton)

        val switchThemeBtnId = rule.activity.resources.getIdentifier("btn_switch_theme", "id", rule.activity.packageName)
        val switchThemeBtn = rule.activity.findViewById<View>(switchThemeBtnId)
        assertTrue(switchThemeBtn is ImageButton)

        val avatarViewId = rule.activity.resources.getIdentifier("iv_avatar", "id", rule.activity.packageName)
        val avatarView = rule.activity.findViewById<View>(avatarViewId)
        assertTrue(avatarView is ImageView)

        val nickNameTextId = rule.activity.resources.getIdentifier("tv_nick_name", "id", rule.activity.packageName)
        val nickNameText = rule.activity.findViewById<View>(nickNameTextId)
        assertTrue(nickNameText is TextView)

        val rankTextId = rule.activity.resources.getIdentifier("tv_rank", "id", rule.activity.packageName)
        val rankText = rule.activity.findViewById<View>(rankTextId)
        assertTrue(rankText is TextView)

        val ratingTextId = rule.activity.resources.getIdentifier("tv_rating", "id", rule.activity.packageName)
        val ratingText = rule.activity.findViewById<View>(ratingTextId)
        assertTrue(ratingText is TextView)

        val respectTextId = rule.activity.resources.getIdentifier("tv_respect", "id", rule.activity.packageName)
        val respectText = rule.activity.findViewById<View>(respectTextId)
        assertTrue(respectText is TextView)

        val firstNameId = rule.activity.resources.getIdentifier("et_first_name", "id", rule.activity.packageName)
        val firstName = rule.activity.findViewById<View>(firstNameId)
        assertTrue(firstName is EditText)

        val lastNameId = rule.activity.resources.getIdentifier("et_last_name", "id", rule.activity.packageName)
        val lastName = rule.activity.findViewById<View>(lastNameId)
        assertTrue(lastName is EditText)

        val aboutId = rule.activity.resources.getIdentifier("et_about", "id", rule.activity.packageName)
        val about = rule.activity.findViewById<View>(aboutId)
        assertTrue(about is EditText)

        val wrAboutId = rule.activity.resources.getIdentifier("wr_about", "id", rule.activity.packageName)
        val wrAbout = rule.activity.findViewById<View>(wrAboutId)
        assertTrue(wrAbout is TextInputLayout)

        val repoId = rule.activity.resources.getIdentifier("et_repository", "id", rule.activity.packageName)
        val repo = rule.activity.findViewById<View>(repoId)
        assertTrue(repo is EditText)

        val weRepoId = rule.activity.resources.getIdentifier("wr_repository", "id", rule.activity.packageName)
        val weRepo = rule.activity.findViewById<View>(weRepoId)
        assertTrue(weRepo is TextInputLayout)
    }
}