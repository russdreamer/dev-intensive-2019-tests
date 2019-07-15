package ru.skillbranch.devintensive

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.skillbranch.devintensive.models.Bender

@RunWith(AndroidJUnit4::class)
class Task6 {
    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun validateTest1(){
        assertEquals("Как меня зовут?", rule.activity.textTxt.text)
        assertEquals(Bender.Status.NORMAL, rule.activity.benderObj.status)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("bender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("Имя должно начинаться с заглавной буквы\nКак меня зовут?", rule.activity.textTxt.text)
        assertEquals(Bender.Status.NORMAL, rule.activity.benderObj.status)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("Bender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("Отлично - ты справился\nНазови мою профессию?", rule.activity.textTxt.text)
        assertEquals(Bender.Status.NORMAL, rule.activity.benderObj.status)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("Robot"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("Профессия должна начинаться со строчной буквы\nНазови мою профессию?", rule.activity.textTxt.text)
        assertEquals(Bender.Status.NORMAL, rule.activity.benderObj.status)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("robot"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("Это неправильный ответ\nНазови мою профессию?", rule.activity.textTxt.text)
        assertEquals(Bender.Status.WARNING, rule.activity.benderObj.status)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("bender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("Отлично - ты справился\nИз чего я сделан?", rule.activity.textTxt.text)
        assertEquals(Bender.Status.WARNING, rule.activity.benderObj.status)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("ferrum_57"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("Материал не должен содержать цифр\nИз чего я сделан?", rule.activity.textTxt.text)
        assertEquals(Bender.Status.WARNING, rule.activity.benderObj.status)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText(" !_ ferrum _?"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("Это неправильный ответ\nИз чего я сделан?", rule.activity.textTxt.text)
        assertEquals(Bender.Status.DANGER, rule.activity.benderObj.status)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("iron"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("Отлично - ты справился\nКогда меня создали?", rule.activity.textTxt.text)
        assertEquals(Bender.Status.DANGER, rule.activity.benderObj.status)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("02.01.1817"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("Год моего рождения должен содержать только цифры\nКогда меня создали?", rule.activity.textTxt.text)
        assertEquals(Bender.Status.DANGER, rule.activity.benderObj.status)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("May 14 1967"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("Год моего рождения должен содержать только цифры\nКогда меня создали?", rule.activity.textTxt.text)
        assertEquals(Bender.Status.DANGER, rule.activity.benderObj.status)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("2993"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("Отлично - ты справился\nМой серийный номер?", rule.activity.textTxt.text)
        assertEquals(Bender.Status.DANGER, rule.activity.benderObj.status)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("1CvtR34Rt"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("Серийный номер содержит только цифры, и их 7\nМой серийный номер?", rule.activity.textTxt.text)
        assertEquals(Bender.Status.DANGER, rule.activity.benderObj.status)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("3 3 4 2"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("Серийный номер содержит только цифры, и их 7\nМой серийный номер?", rule.activity.textTxt.text)
        assertEquals(Bender.Status.DANGER, rule.activity.benderObj.status)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("1234567"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("Это неправильный ответ\nМой серийный номер?", rule.activity.textTxt.text)
        assertEquals(Bender.Status.CRITICAL, rule.activity.benderObj.status)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("2716057"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("Отлично - ты справился\nНа этом все, вопросов больше нет", rule.activity.textTxt.text)
        assertEquals(Bender.Status.CRITICAL, rule.activity.benderObj.status)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText(""))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("На этом все, вопросов больше нет", rule.activity.textTxt.text)
        assertEquals(Bender.Status.CRITICAL, rule.activity.benderObj.status)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText(" fdk e_f+!ef t556 "))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("На этом все, вопросов больше нет", rule.activity.textTxt.text)
        assertEquals(Bender.Status.CRITICAL, rule.activity.benderObj.status)
    }

    @Test
    fun validateTest2(){
        assertEquals("Как меня зовут?", rule.activity.textTxt.text)
        assertEquals(Bender.Status.NORMAL, rule.activity.benderObj.status)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("bender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.pressImeActionButton())

        assertEquals("Имя должно начинаться с заглавной буквы\nКак меня зовут?", rule.activity.textTxt.text)
        assertEquals(Bender.Status.NORMAL, rule.activity.benderObj.status)
    }
}