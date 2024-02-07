package org.jetbrains.analog.lang

import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.LanguageFileType




class AnalogLanguage private constructor() :  Language( "Analog") {
    companion object {
        val INSTANCE: AnalogLanguage = AnalogLanguage()
    }

    override fun getDisplayName(): String {
        return "Analog"
    }

    override fun isCaseSensitive(): Boolean {
        return true
    }

    override fun getAssociatedFileType(): LanguageFileType {
        return MarkoFileType.INSTANCE
    }
}