package com.github.ssogon.sejong

import com.google.common.collect.Range

class Hangul private constructor(
    private val initialConsonant: Char,
    private val vowel: Char,
    private val finalConsonant: Char
) {
    companion object {
        private val HANGUL_UNICODE_RANGE = Range.closed('가', '힣')
        private val INITIAL_CONSONANTS = charArrayOf(
            'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ',
            'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ',
            'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ',
            'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
        )
        private val VOWELS = charArrayOf(
            'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ',
            'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅘ',
            'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ',
            'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ',
            'ㅣ'
        )
        private val FINAL_CONSONANTS = charArrayOf(
            Character.MIN_VALUE,
            'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ',
            'ㄶ', 'ㄷ', 'ㄹ', 'ㄺ', 'ㄻ',
            'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ',
            'ㅁ', 'ㅂ', 'ㅄ', 'ㅅ', 'ㅆ',
            'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ',
            'ㅍ', 'ㅎ'
        )

        @JvmStatic
        fun from(char: Char): Hangul {
            val normalizedValue = char - HANGUL_UNICODE_RANGE.lowerEndpoint()
            val initialConsonant = INITIAL_CONSONANTS[normalizedValue / FINAL_CONSONANTS.size / VOWELS.size]
            val vowel = VOWELS[normalizedValue / FINAL_CONSONANTS.size % VOWELS.size]
            val finalConsonant = FINAL_CONSONANTS[normalizedValue % FINAL_CONSONANTS.size]
            return Hangul(initialConsonant, vowel, finalConsonant)
        }
    }

    fun hasFinalConsonant() = finalConsonant != Char.MIN_VALUE
}
