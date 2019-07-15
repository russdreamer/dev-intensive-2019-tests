package ru.skillbranch.devintensive

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Task3 {
    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun listenAnswerHalfPosTest(){
        assertEquals("Как меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Валя Голубкова"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Bender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nНазови мою профессию?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("актёр мультфильма"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nНазови мою профессию?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("actor"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nНазови мою профессию?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("сгибальщик"))
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
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("2716057"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("На этом все, вопросов больше нет", rule.activity.textTxt.text)
    }

    @Test
    fun listenAnswerNegativeTest1(){
        assertEquals("Как меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Валя Голубкова"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Bender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nНазови мою профессию?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("актёр мультфильма"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nНазови мою профессию?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("хозяин казино с блэкджеком и ..."))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nНазови мою профессию?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("сгибальщик"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nИз чего я сделан?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("iron"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nКогда меня создали?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("2993"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nМой серийный номер?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("2716054"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ. Давай все по новой\nКак меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Bender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nНазови мою профессию?", rule.activity.textTxt.text)

    }

    @Test
    fun listenAnswerNegativeTest2(){
        assertEquals("Как меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Фрай"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Зоя"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Бандарчук"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Bomberman"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("Это неправильный ответ. Давай все по новой\nКак меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Фрай"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Зоя"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Бандарчук"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Bomberman"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("Это неправильный ответ. Давай все по новой\nКак меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Фрай"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Зоя"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Бандарчук"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Bomberman"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ. Давай все по новой\nКак меня зовут?", rule.activity.textTxt.text)
    }

    @Test
    fun listenAnswerNegativeUITest(){
        assertEquals("Как меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("Ender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())

        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("Ender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("Ender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        rotateScreen(rule.activity, true)
        rotateScreen(rule.activity, false)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("Ender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ. Давай все по новой\nКак меня зовут?", rule.activity.textTxt.text)
    }

    @Test
    fun saveStateWhenRotateTest(){
        assertEquals("Как меня зовут?", rule.activity.textTxt.text)
        val normalColorFilter = PorterDuffColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.MULTIPLY)
        assertEquals(normalColorFilter, rule.activity.benderImage.colorFilter)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Tinder"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        val warnColorFilter = PorterDuffColorFilter(Color.rgb(255, 120, 0), PorterDuff.Mode.MULTIPLY)
        assertEquals(warnColorFilter, rule.activity.benderImage.colorFilter)

        rotateScreen(rule.activity, true)
        assertEquals("Как меня зовут?", rule.activity.textTxt.text)
        assertEquals(warnColorFilter, rule.activity.benderImage.colorFilter)

        rotateScreen(rule.activity, false)
        assertEquals("Как меня зовут?", rule.activity.textTxt.text)
        assertEquals(warnColorFilter, rule.activity.benderImage.colorFilter)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Blender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        val dangerColorFilter = PorterDuffColorFilter(Color.rgb(255, 60, 60), PorterDuff.Mode.MULTIPLY)
        assertEquals(dangerColorFilter, rule.activity.benderImage.colorFilter)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Espander"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        val critColorFilter = PorterDuffColorFilter(Color.rgb(255, 0, 0), PorterDuff.Mode.MULTIPLY)
        assertEquals(critColorFilter, rule.activity.benderImage.colorFilter)

        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Labrador"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ. Давай все по новой\nКак меня зовут?", rule.activity.textTxt.text)
        assertEquals(normalColorFilter, rule.activity.benderImage.colorFilter)
    }
}