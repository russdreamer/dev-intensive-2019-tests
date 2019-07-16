package ru.skillbranch.devintensive

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class Task3 {
    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun listenAnswerHalfPosTest() {
        assertEquals("Как меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
            .perform(ViewActions.replaceText("Валя Голубкова"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Bender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nНазови мою профессию?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
            .perform(ViewActions.replaceText("актёр мультфильма"))
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
    fun listenAnswerNegativeTest1() {
        assertEquals("Как меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
            .perform(ViewActions.replaceText("Валя Голубкова"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Bender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Отлично - ты справился\nНазови мою профессию?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
            .perform(ViewActions.replaceText("актёр мультфильма"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ\nНазови мою профессию?", rule.activity.textTxt.text)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
            .perform(ViewActions.replaceText("хозяин казино с блэкджеком и ..."))
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
    fun listenAnswerNegativeTest2() {
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
    fun listenAnswerNegativeUITest() {
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
}