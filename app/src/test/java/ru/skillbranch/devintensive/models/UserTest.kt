package ru.skillbranch.devintensive.models

import org.junit.Assert.*
import org.junit.Test
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import java.util.*

class UserTest {
    @Test
    fun makeUserTest(){
        assertEquals(User("0", "Иван", "Кузьмин").firstName, User.makeUser("Иван Кузьмин").firstName)
        assertEquals(User("0", "Иван", "Кузьмин").lastName, User.makeUser("Иван Кузьмин").lastName)
    }

    @Test
    fun builderTest(){
        val date = Date()

        val user1 = User(
            "5",
            "Никола",
            "Тесла",
            null,
            0,
            1000,
            date.add(-2, TimeUnits.DAY),
            false)

        val user2 = User.Builder().id("5")
            .firstName("Никола")
            .lastName("Тесла")
            .avatar(null)
            .rating(0)
            .respect(1000)
            .lastVisit(date.add(-2, TimeUnits.DAY))
            .isOnline(false)
            .build()

        val user3 = User.Builder().build()

        assertEquals(user1, user2)
        assertTrue(user3 is User)
        assertNotEquals(null, user3.id)
        assertEquals(null, user3.firstName)
        assertEquals(null, user3.lastName)
        assertEquals(null, user3.avatar)
        assertEquals(0, user3.rating)
        assertEquals(0, user3.respect)
        assertNotEquals(null, user3.lastVisit)
        assertFalse(user3.isOnline)
    }
}