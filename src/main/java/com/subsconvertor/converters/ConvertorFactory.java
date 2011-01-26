package com.subsconvertor.converters;

import com.subsconvertor.detector.SubtitleType;
import com.subsconvertor.exception.SystemException;

/**
 *
 */
public class ConvertorFactory {

    public static Converter create(SubtitleType type) {
        if (type.equals(SubtitleType.SRT)) {
            return new SrtConverter();
        } else if (type.equals(SubtitleType.SUB)) {
            return new SubConverter();
        } else {
            throw new SystemException("Subtitle type not recognized");
        }
    }
}
