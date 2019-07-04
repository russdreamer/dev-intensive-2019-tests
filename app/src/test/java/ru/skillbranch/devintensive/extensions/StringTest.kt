package ru.skillbranch.devintensive.extensions

import org.junit.Assert.*
import org.junit.Test

class StringTest {
    @Test
    fun stripHtmlTest() {
        /* skillBranch tests */
        assertEquals("Образовательное IT-сообщество Skill Branch",
            "<p class=\"title\">Образовательное IT-сообщество Skill Branch</p>".stripHtml())
        assertEquals("Образовательное IT-сообщество Skill Branch",
            "<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml())

        /* additional tests */
        assertEquals("single", "&amp;&lt;&gt;single&#39;&quot;".stripHtml())
        assertEquals("", "&amp;&lt;&gt;&#39;&quot;".stripHtml())
        assertEquals(" ", "&amp;&lt;&gt;    &#39;&quot;".stripHtml())
        assertEquals("1978", "<path fill=\"Color\" d=\"M11.63 10z\"></svg><span>1978</span>".stripHtml())
        assertEquals("", "&gt;<head>&#39;&quot;</head>".stripHtml())
        assertEquals(" ", "&gt;<head> &quot; </head>".stripHtml())
        assertEquals("&игра; amp lt &gt 39; meters ()quot;", "&игра; amp lt &gt 39; meters ()quot;".stripHtml())
        assertEquals(" one two ", "  one   two ".stripHtml())
        assertEquals("null", "null".stripHtml())
        val longHtml = """
            <TD valign="top" style="padding-bottom:15px;"> <b>line1<b> </TD>
            <TD valign="top"> <span class="HeadTitleNews"> line2</span>
            <img src='http://2011WaterpoloF.jpg' >
            <div style="margin: 0in 0in 0pt">line3</div>
        """.trimIndent()
        assertEquals(" line1 \n line2\n\nline3", longHtml.stripHtml())
    }

    @Test
    fun truncateTest() {
        /* skillBranch tests */
        assertEquals("Bender Bending R...", "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate())
        assertEquals("Bender Bending...", "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15))
        assertEquals("A", "A     ".truncate(3))

        /* additional tests */
        assertEquals("too lo...", "   too long line with lots of spaces before".truncate(6))
        assertEquals("too short", "too short".truncate(20))
        assertEquals("12345", "12345".truncate(5))
        assertEquals("1234...", "12345".truncate(4))
        assertEquals("12345", "12345  ".truncate(5))
        assertEquals("tab", "tab    ".truncate(5))
        assertEquals("dots......", "dots... a lot".truncate(7))
        assertEquals("abc", "abc    ".truncate(15))
        assertEquals("123456...", "123456789".truncate(6))
        assertEquals("123456789", "123456789".truncate(9))
        assertEquals("Bender Bending R...", "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate())
        assertEquals("Bender Bending...", "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15))
        assertEquals("1", "1     ".truncate(3))
    }
}