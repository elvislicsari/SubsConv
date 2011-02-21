package com.subsconvertor.converters.type;

import com.subsconvertor.model.SubtitleType;
import com.subsconvertor.exception.SystemException;

/**
 *
 */
public class SubtitleTypeConverterFactory {

    public static SubtitleTypeConverter create(SubtitleType fromType, SubtitleType intoType) {
        if (fromType.equals(SubtitleType.MicroDVD) &&
                intoType.equals(SubtitleType.SubRip)) {
            return new MicroDVDToSubRipConverter();
        } else if (fromType.equals(SubtitleType.SubRip) &&
                intoType.equals(SubtitleType.MicroDVD)) {
            return new SubRipToMicroDVDConverter();
        } else {
            throw new SystemException("Unsuported SubtitleTypeConverter");
        }
    }
}
