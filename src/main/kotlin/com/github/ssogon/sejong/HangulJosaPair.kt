package com.github.ssogon.sejong

@Suppress("SpellCheckingInspection")
enum class HangulJosaPair(private val josaForFinalConsonant: String, private val josaForVowel: String) {
    EUN_NEUN("은", "는"),
    I_GA("이", "가"),
    EUL_REUL("을", "를"),
    GWA_WA("과", "와"),
    A_YA("아", "야"),
    IYEO_YEO("이여", "여"),
    IRANG_RANG("이랑", "랑"),
    EURO_RO("으로", "로");

    fun resolve(hangul: Hangul) = if (hangul.hasFinalConsonant()) josaForFinalConsonant else josaForVowel

    fun resolve(character: Char) = resolve(Hangul.from(character))
}
