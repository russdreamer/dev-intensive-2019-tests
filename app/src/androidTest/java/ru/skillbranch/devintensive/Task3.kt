package ru.skillbranch.devintensive

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.skillbranch.devintensive.models.Bender

@RunWith(AndroidJUnit4::class)
class Task3 {
    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun listenAnswerHalfPosTest(){
        val bender = Bender()
        assertEquals("Как меня зовут?", bender.question.question)
        var response = bender.listenAnswer("Валя Голубкова")
        assertEquals("Это неправильный ответ\nКак меня зовут?", response.first)
        response = bender.listenAnswer("bender")
        assertEquals("Отлично - ты справился\nНазови мою профессию?", response.first)
        response = bender.listenAnswer("актёр мультфильма")
        assertEquals("Это неправильный ответ\nНазови мою профессию?", response.first)
        response = bender.listenAnswer("")
        assertEquals("Это неправильный ответ\nНазови мою профессию?", response.first)
        response = bender.listenAnswer("сгибальщик")
        assertEquals("Отлично - ты справился\nИз чего я сделан?", response.first)
        response = bender.listenAnswer("iron")
        assertEquals("Отлично - ты справился\nКогда меня создали?", response.first)
        response = bender.listenAnswer("2993")
        assertEquals("Отлично - ты справился\nМой серийный номер?", response.first)
        response = bender.listenAnswer("2716057")
        assertEquals("Отлично - ты справился\nНа этом все, вопросов больше нет", response.first)
    }

    @Test
    fun listenAnswerNegativeTest1(){
        val bender = Bender()
        assertEquals("Как меня зовут?", bender.question.question)
        var response = bender.listenAnswer("Валя Голубкова")
        assertEquals("Это неправильный ответ\nКак меня зовут?", response.first)
        response = bender.listenAnswer("bender")
        assertEquals("Отлично - ты справился\nНазови мою профессию?", response.first)
        response = bender.listenAnswer("актёр мультфильма")
        assertEquals("Это неправильный ответ\nНазови мою профессию?", response.first)
        response = bender.listenAnswer("хозяин казино с блэкджеком и ...")
        assertEquals("Это неправильный ответ\nНазови мою профессию?", response.first)
        response = bender.listenAnswer("сгибальщик")
        assertEquals("Отлично - ты справился\nИз чего я сделан?", response.first)
        response = bender.listenAnswer("iron")
        assertEquals("Отлично - ты справился\nКогда меня создали?", response.first)
        response = bender.listenAnswer("2993")
        assertEquals("Отлично - ты справился\nМой серийный номер?", response.first)
        response = bender.listenAnswer("2716054")
        assertEquals("Это неправильный ответ. Давай все по новой\nКак меня зовут?", response.first)
        response = bender.listenAnswer("bender")
        assertEquals("Отлично - ты справился\nНазови мою профессию?", response.first)
    }

    @Test
    fun listenAnswerNegativeTest2(){
        val bender = Bender()
        assertEquals("Как меня зовут?", bender.question.question)
        var response = bender.listenAnswer("Фрай")
        assertEquals("Это неправильный ответ\nКак меня зовут?", response.first)
        response = bender.listenAnswer("Зоя")
        assertEquals("Это неправильный ответ\nКак меня зовут?", response.first)
        response = bender.listenAnswer("Бандарчук")
        assertEquals("Это неправильный ответ\nКак меня зовут?", response.first)
        response = bender.listenAnswer("Bomberman")

        assertEquals("Это неправильный ответ. Давай все по новой\nКак меня зовут?", response.first)
        response = bender.listenAnswer("Фрай")
        assertEquals("Это неправильный ответ\nКак меня зовут?", response.first)
        response = bender.listenAnswer("Зоя")
        assertEquals("Это неправильный ответ\nКак меня зовут?", response.first)
        response = bender.listenAnswer("Бандарчук")
        assertEquals("Это неправильный ответ\nКак меня зовут?", response.first)
        response = bender.listenAnswer("Bomberman")

        assertEquals("Это неправильный ответ. Давай все по новой\nКак меня зовут?", response.first)
        response = bender.listenAnswer("Фрай")
        assertEquals("Это неправильный ответ\nКак меня зовут?", response.first)
        response = bender.listenAnswer("Зоя")
        assertEquals("Это неправильный ответ\nКак меня зовут?", response.first)
        response = bender.listenAnswer("Бандарчук")
        assertEquals("Это неправильный ответ\nКак меня зовут?", response.first)
        response = bender.listenAnswer("Bomberman")
        assertEquals("Это неправильный ответ. Давай все по новой\nКак меня зовут?", response.first)
    }

    @Test
    fun listenAnswerNegativeUITest(){
        assertEquals("Как меня зовут?", rule.activity.textTxt.text)
        assertEquals(Bender.Status.NORMAL, rule.activity.benderObj.status)

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
        Thread.sleep(2000)
        Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("Ender"))
        Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
        assertEquals("Это неправильный ответ. Давай все по новой\nКак меня зовут?", rule.activity.textTxt.text)
    }
}