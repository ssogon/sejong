package com.github.ssogon.sejong

@Suppress("SpellCheckingInspection")
class HangulJosaFormatter private constructor() {
    companion object {
        @JvmStatic
        fun format(template: String, vararg args: HangulJosaPair): String {
            val stringBuilder = StringBuilder(template.length + args.size * 2)
            var templateStart = 0
            var i = 0
            while (i < args.size) {
                val placeHolderStart = template.indexOf("%s", templateStart)
                if (placeHolderStart == -1) {
                    break
                }
                stringBuilder.append(template, templateStart, placeHolderStart)
                stringBuilder.append(args[i++].resolve(template[placeHolderStart - 1]))
                templateStart = placeHolderStart + 2
            }
            stringBuilder.append(template, templateStart, template.length)
            return stringBuilder.toString()
        }
    }
}