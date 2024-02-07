package com.example.markoplugin.lang

import com.example.markoplugin.MarkoIcon
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon





class MarkoFileType : LanguageFileType(MarkoLanguage.INSTANCE) {

    companion object {
        @JvmField
        val INSTANCE: MarkoFileType = MarkoFileType()
    }
    override fun getName(): String {
        return "Marko"
    }

    override fun getDescription(): String {
        return "Marko"
    }

    override fun getDefaultExtension(): String {
        return "marko"
    }

    override fun getIcon(): Icon {
        return MarkoIcon.FILE
    }


}
