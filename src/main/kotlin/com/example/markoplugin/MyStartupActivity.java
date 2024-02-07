package com.example.markoplugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.ProjectActivity;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.plugins.textmate.configuration.TextMateUserBundlesSettings;

public class MyStartupActivity implements ProjectActivity {
    @Override
    public Object execute(@NotNull Project project, @NotNull Continuation<? super Unit> continuation) {
        TextMateUserBundlesSettings settings = TextMateUserBundlesSettings.getInstance();
        settings.addBundle("/syntax/marko.tmLanguage", "Marko");
        return null;
    }
}
