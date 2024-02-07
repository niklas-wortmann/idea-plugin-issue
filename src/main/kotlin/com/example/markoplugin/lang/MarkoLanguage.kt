package com.example.markoplugin.lang

import com.intellij.lang.Language




class MarkoLanguage private constructor() :  Language( "Marko") {
    companion object {
        @JvmField
        val INSTANCE: MarkoLanguage = MarkoLanguage()
    }
}