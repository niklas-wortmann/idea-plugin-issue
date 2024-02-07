package org.jetbrains.analog.lang

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon





class AnalogFileType  private constructor() : LanguageFileType(AnalogLanguage.INSTANCE) {
    override fun getName(): String = "Analog"
    override fun getDescription(): String = "Analog"
    override fun getDefaultExtension(): String = "ng"
    override fun getIcon(): Icon = AnalogIcon.FILE

    companion object {
        @JvmField
        val INSTANCE = AnalogFileType()
    }
}