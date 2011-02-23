package com.subsconvertor.translators;

import com.google.api.translate.Language;
import com.google.api.translate.Translator;
import com.subsconvertor.utils.Globals;
import com.tecnick.htmlutils.htmlentities.HTMLEntities;

import java.util.Scanner;

public abstract class AbstractSubtitleTranslator implements SubtitleTranslator {

    private Language originalLanguage;
    private Language destinationLanguage;

    public void setOriginalLanguage(Language language) {
        originalLanguage = language;
    }

    public void setDestinationLanguage(Language language) {
        destinationLanguage = language;
    }

    public Language getOriginalLanguage() {
        return originalLanguage;
    }

    public Language getDestinationLanguage() {
        return destinationLanguage;
    }
}
