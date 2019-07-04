package ru.skillbranch.devintensive.models

import org.junit.Assert.*
import org.junit.Test
import java.util.*

class BaseMessageTest {
    @Test
    fun makeMessageTest(){
        val user = User.makeUser("Иван Кузьмин")
        var message = BaseMessage.makeMessage(user, Chat("0"), Date(), "text", "any text message")
        assertTrue(message is TextMessage)
        assertEquals("0", message.id)
        assertTrue(message.from === user)
        message = BaseMessage.makeMessage(user, Chat("0"), Date(), "image", "https://anyurl.com",true)
        assertTrue(message is ImageMessage)
        assertEquals("1", message.id)
        assertTrue(message.isIncoming)
        assertEquals((message as ImageMessage).image, "https://anyurl.com")
    }
}