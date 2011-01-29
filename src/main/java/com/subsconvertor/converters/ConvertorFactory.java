package com.subsconvertor.converters;

import com.subsconvertor.detector.SubtitleType;
import com.subsconvertor.exception.SystemException;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ConvertorFactory {

    private static final Map<SubtitleType, Converter> cache = new HashMap<SubtitleType, Converter>(2) {{
        put(SubtitleType.SubRip, new SubRipConverter());
        put(SubtitleType.MicroDVD, new MicroDVDConverter());
    }};

    public static Converter create(SubtitleType type) {
        if (cache.containsKey(type)) {
            return cache.get(type);
        } else {
            throw new SystemException("Subtitle type not recognized");
        }
    }
}
