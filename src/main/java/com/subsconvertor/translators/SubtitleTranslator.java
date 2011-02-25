package com.subsconvertor.translators;

import com.google.api.translate.Language;

/**
 *
 */
public interface SubtitleTranslator {

    StringBuilder translate(StringBuilder sb) throws Exception;

    void setOriginalLanguage(Language language);

    void setDestinationLanguage(Language language);

}
