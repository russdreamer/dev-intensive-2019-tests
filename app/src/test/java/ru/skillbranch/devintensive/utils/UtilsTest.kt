package ru.skillbranch.devintensive.utils

import org.junit.Assert.*
import org.junit.Test

class UtilsTest {
    @Test
    fun parseFullNameTest(){
        /* skillBranch tests */
        assertEquals(null to null, Utils.parseFullName(null))
        assertEquals(null to null, Utils.parseFullName(""))
        assertEquals(null to null, Utils.parseFullName(" "))
        assertEquals("John" to null, Utils.parseFullName("John"))
        /* additional tests */
        assertEquals(null to null, Utils.parseFullName("     "))
        assertEquals("null" to null, Utils.parseFullName("null"))
        assertEquals("John" to null, Utils.parseFullName("John      "))
        assertEquals("John" to null, Utils.parseFullName(" John     "))
    }

    @Test
    fun toInitialsTest(){
        /* skillBranch tests */
        assertEquals("JD", Utils.toInitials("john", "doe"))
        assertEquals("J", Utils.toInitials("John", null))
        assertEquals(null, Utils.toInitials(null, null))
        assertEquals(null, Utils.toInitials(" ", ""))

        /* additional tests */
        assertEquals(null, Utils.toInitials(" ", null))
        assertEquals(null, Utils.toInitials(null, ""))
        assertEquals("T", Utils.toInitials(null, "  tommy"))
        assertEquals("ST", Utils.toInitials("  samuel  ", "  tommy"))
        assertEquals("J", Utils.toInitials(null, "John"))
    }

    @Test
    fun transliteration_test() {
        /* skillBranch tests */
        assertEquals("Zhenya Stereotipov", Utils.transliteration("Женя Стереотипов"))
        assertEquals("Amazing_Petr", Utils.transliteration("Amazing Петр","_"))

        /* additional tests */
        assertEquals("iVan Stereotizhov", Utils.transliteration("иВан Стереотижов"))
        assertEquals("Amazing_PeZhr", Utils.transliteration("Amazing ПеЖр", "_"))
        assertEquals("aAbBvVgGdDeEeEzhZhzZiIiIkKlL", Utils.transliteration("аАбБвВгГдДеЕёЁжЖзЗиИйЙкКлЛ"))
        assertEquals("mMnNoOpPrRsStTuUfFhHcCshShsh'Sh'", Utils.transliteration("мМнНоОпПрРсСтТуУфФхХцЦшШщЩ"))
        assertEquals("eEyuYuyaYa", Utils.transliteration("ъЪьЬэЭюЮяЯ"))
        assertEquals("123|!,^-=+><|english", Utils.transliteration("123 !,^-=+>< english", "|"))
        assertEquals("Zhizha ZhiZhnaYa", Utils.transliteration("Жижа ЖиЖнаЯ"))
        assertEquals("Sobaka is a dog", Utils.transliteration("Собака dog", " is a "))
    }
}
