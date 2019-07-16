package ru.skillbranch.devintensive

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import ru.skillbranch.devintensive.models.Bender

class Task2 {
    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun listenAnswerPositiveTest1() {
        assertEquals("Как меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Bender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nНазови мою профессию?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("bender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nИз чего я сделан?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("iron"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nКогда меня создали?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("2993"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nМой серийный номер?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("2716057"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nНа этом все, вопросов больше нет", rule.activity.textTxt.text)
    }

    @Test
    fun listenAnswerPositiveTest2() {
        assertEquals("Как меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Бендер"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nНазови мою профессию?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("сгибальщик"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nИз чего я сделан?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("дерево"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nКогда меня создали?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("2993"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nМой серийный номер?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("2716057"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nНа этом все, вопросов больше нет", rule.activity.textTxt.text)
    }

    @Test
    fun saveStateWhenRotateTest() {
        assertEquals("Как меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Bender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nНазови мою профессию?", rule.activity.textTxt.text)
        rotateScreen(rule.activity, true)
        assertEquals("Назови мою профессию?", rule.activity.textTxt.text)
        rotateScreen(rule.activity, false)
        assertEquals("Назови мою профессию?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("bender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nИз чего я сделан?", rule.activity.textTxt.text)
    }

    @Test
    fun colorStatusTest() {
        assertEquals(255, Bender.Status.NORMAL.color.first)
        assertEquals(255, Bender.Status.NORMAL.color.second)
        assertEquals(255, Bender.Status.NORMAL.color.third)

        assertEquals(255, Bender.Status.WARNING.color.first)
        assertEquals(120, Bender.Status.WARNING.color.second)
        assertEquals(0, Bender.Status.WARNING.color.third)

        assertEquals(255, Bender.Status.DANGER.color.first)
        assertEquals(60, Bender.Status.DANGER.color.second)
        assertEquals(60, Bender.Status.DANGER.color.third)

        assertEquals(255, Bender.Status.CRITICAL.color.first)
        assertEquals(0, Bender.Status.CRITICAL.color.second)
        assertEquals(0, Bender.Status.CRITICAL.color.third)
    }
}