package com.github.ssogon.sejong

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@Suppress("SpellCheckingInspection")
internal class HangulJosaFormatterTest {
    @Test
    fun format() {
        val text = "구구%s 새로 마구찌르기%s 배웠다."
        val formattedText = HangulJosaFormatter.format(text, HangulJosaPair.EUN_NEUN, HangulJosaPair.EUL_REUL)

        assertEquals("구구는 새로 마구찌르기를 배웠다.", formattedText)
    }
}