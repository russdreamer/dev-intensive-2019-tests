package ru.skillbranch.devintensive.models

import org.junit.Assert.*
import org.junit.Test

class BenderTest {
    @Test
    fun listenAnswerPositiveTest1(){
        val bender = Bender()
        assertEquals("Как меня зовут?", bender.question.question)
        var response = bender.listenAnswer("bender")
        assertEquals("Отлично - ты справился\nНазови мою профессию?", response.first)
        response = bender.listenAnswer("bender")
        assertEquals("Отлично - ты справился\nИз чего я сделан?", response.first)
        response = bender.listenAnswer("iron")
        assertEquals("Отлично - ты справился\nКогда меня создали?", response.first)
        response = bender.listenAnswer("2993")
        assertEquals("Отлично - ты справился\nМой серийный номер?", response.first)
        response = bender.listenAnswer("2716057")
        assertEquals("Отлично - ты справился\nНа этом все, вопросов больше нет", response.first)
    }

    @Test
    fun listenAnswerPositiveTest2(){
        val bender = Bender()
        assertEquals("Как меня зовут?", bender.question.question)
        var response = bender.listenAnswer("bender")
        assertEquals("Отлично - ты справился\nНазови мою профессию?", response.first)
        response = bender.listenAnswer("сгибальщик")
        assertEquals("Отлично - ты справился\nИз чего я сделан?", response.first)
        response = bender.listenAnswer("дерево")
        assertEquals("Отлично - ты справился\nКогда меня создали?", response.first)
        response = bender.listenAnswer("2993")
        assertEquals("Отлично - ты справился\nМой серийный номер?", response.first)
        response = bender.listenAnswer("2716057")
        assertEquals("Отлично - ты справился\nНа этом все, вопросов больше нет", response.first)
    }

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
    fun listenAnswerNegative1(){
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
    fun listenAnswerNegative2(){
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
    }
}