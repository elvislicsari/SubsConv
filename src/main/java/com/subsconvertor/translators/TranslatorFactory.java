package com.subsconvertor.translators;

import com.subsconvertor.exception.SystemException;
import com.subsconvertor.model.SubtitleType;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public final class TranslatorFactory {

    private static final Map<SubtitleType, SubtitleTranslator> cache = new HashMap<SubtitleType, SubtitleTranslator>(2) {{
        put(SubtitleType.SubRip, new SubRipTranslator());
        put(SubtitleType.MicroDVD, new MicroDVDTranslator());
    }};

    private TranslatorFactory() {
    }

    public static SubtitleTranslator create(SubtitleType type) {
        if (cache.containsKey(type)) {
            return cache.get(type);
        } else {
            throw new SystemException("Subtitle type not recognized");
        }
    }

}
