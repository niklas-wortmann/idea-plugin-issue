// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.example.markoplugin.lsp

import com.intellij.lang.typescript.compiler.languageService.TypeScriptLanguageServiceUtil
import com.intellij.lang.typescript.lsp.*
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServerSupportProvider
import com.intellij.platform.lsp.api.LspServerSupportProvider.LspServerStarter
import com.example.markoplugin.lang.MarkoFileType
import org.jetbrains.annotations.ApiStatus

val markoLspServerPackageDescriptor = LspServerPackageDescriptor("@marko/language-server",
                                                                 "1.1.18",
                                                                 "./bin.js")

class MarkoLspServerSupportProvider : LspServerSupportProvider {
  override fun fileOpened(project: Project, file: VirtualFile, serverStarter: LspServerStarter) {
    if (isServiceEnabledAndAvailable(project, file)) {
      serverStarter.ensureServerStarted(MarkoLspServerDescriptor(project))
    }
  }
}

class MarkoLspServerDescriptor(project: Project) : JSFrameworkLspServerDescriptor(project, MarkoLspExecutableDownloader, "Astro") {
  override fun isSupportedFile(file: VirtualFile): Boolean = isFileAcceptableForService(file)
}

@ApiStatus.Experimental
object MarkoLspExecutableDownloader : LspServerDownloader(markoLspServerPackageDescriptor)

fun isServiceEnabledAndAvailable(project: Project, context: VirtualFile): Boolean {
    return isFileAcceptableForService(context) &&
            MarkoLspExecutableDownloader.getExecutableOrRefresh(project) != null
}

fun isFileAcceptableForService(file: VirtualFile): Boolean {
    if (!TypeScriptLanguageServiceUtil.IS_VALID_FILE_FOR_SERVICE.value(file)) return false
    return file.fileType.defaultExtension == "marko"
}