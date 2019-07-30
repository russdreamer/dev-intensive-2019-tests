package ru.skillbranch.devintensive

import android.widget.EditText
import android.widget.TextView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import ru.skillbranch.devintensive.ui.profile.ProfileActivity

class Task6 {
    @Rule
    @JvmField
    val rule = ActivityTestRule(ProfileActivity::class.java)

    var nickNameTextId: Int? = null
    var nickNameText: TextView? = null
    var firstNameId: Int? = null
    var firstName: EditText? = null
    var lastNameId: Int? = null
    var lastName: EditText? = null
    var editBtnId: Int? = null

    @Before
    fun beforeTest(){
        updateFields()
    }

    @Test
    fun nickNameTest(){
        fillInfo("", "")
        assertEquals("", nickNameText!!.text)
        fillInfo("Женя", "Стереотипов")
        assertEquals("Zhenya_Stereotipov", nickNameText!!.text)
        fillInfo("Amazing", "Петр")
        assertEquals("Amazing_Petr", nickNameText!!.text)
        fillInfo("иВан", "Стереотижов")
        assertEquals("iVan_Stereotizhov", nickNameText!!.text)
        fillInfo("Amazing", "ПеЖр")
        assertEquals("Amazing_PeZhr", nickNameText!!.text)
        fillInfo("", "аАбБвВгГдДеЕёЁжЖзЗиИйЙкКлЛ")
        assertEquals("aAbBvVgGdDeEeEzhZhzZiIiIkKlL", nickNameText!!.text)
        fillInfo("аАбБвВгГдДеЕёЁжЖзЗиИйЙкКлЛ", "")
        assertEquals("aAbBvVgGdDeEeEzhZhzZiIiIkKlL", nickNameText!!.text)
        fillInfo("", "мМнНоОпПрРсСтТуУфФхХцЦшШщЩ")
        assertEquals("mMnNoOpPrRsStTuUfFhHcCshShsh'Sh'", nickNameText!!.text)
        fillInfo("ъЪьЬэЭюЮяЯ", "")
        assertEquals("eEyuYuyaYa", nickNameText!!.text)
        fillInfo("123", "!,^-=+><english")
        assertEquals("123_!,^-=+><english", nickNameText!!.text)
        fillInfo("Жижа", "ЖиЖнаЯ")
        assertEquals("Zhizha_ZhiZhnaYa", nickNameText!!.text)
    }

    @Test
    fun nickNameOnExitTest(){
        fillInfo("", "")
        assertEquals("", nickNameText!!.text)
        fillInfo("Женя", "Стереотипов")
        assertEquals("Zhenya_Stereotipov", nickNameText!!.text)

        var intent = rule.activity.intent
        rule.finishActivity()
        Thread.sleep(1000)
        rule.launchActivity(intent)
        Thread.sleep(1000)

        updateFields()
        assertEquals("Zhenya_Stereotipov", nickNameText!!.text)
        fillInfo("", "")
        assertEquals("", nickNameText!!.text)

        intent = rule.activity.intent
        rule.finishActivity()
        Thread.sleep(1000)
        rule.launchActivity(intent)
        Thread.sleep(1000)
        updateFields()

        assertEquals("", nickNameText!!.text)
    }

    private fun updateFields() {
        nickNameTextId = rule.activity.resources.getIdentifier("tv_nick_name", "id", rule.activity.packageName)
        nickNameText = rule.activity.findViewById<TextView>(nickNameTextId!!)
        firstNameId = rule.activity.resources.getIdentifier("et_first_name", "id", rule.activity.packageName)
        firstName = rule.activity.findViewById<EditText>(firstNameId!!)
        lastNameId = rule.activity.resources.getIdentifier("et_last_name", "id", rule.activity.packageName)
        lastName = rule.activity.findViewById<EditText>(lastNameId!!)
        editBtnId = rule.activity.resources.getIdentifier("btn_edit", "id", rule.activity.packageName)
    }

    private fun fillInfo(firstName: String, secondName: String) {
        Espresso.onView(ViewMatchers.withId(editBtnId!!)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(firstNameId!!)).perform(ViewActions.replaceText(firstName))
        Espresso.onView(ViewMatchers.withId(lastNameId!!)).perform(ViewActions.replaceText(secondName))
        Espresso.onView(ViewMatchers.withId(editBtnId!!)).perform(ViewActions.click())
    }
}