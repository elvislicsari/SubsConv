package com.subsconvertor;

import com.google.api.translate.Language;
import com.google.api.translate.Translator;
import com.subsconvertor.converters.Converter;
import com.subsconvertor.converters.ConvertorFactory;
import com.subsconvertor.converters.type.SubtitleTypeConverter;
import com.subsconvertor.converters.type.SubtitleTypeConverterFactory;
import com.subsconvertor.detector.SubsDetector;
import com.subsconvertor.model.SubtitleType;
import com.subsconvertor.translators.SubtitleTranslator;
import com.subsconvertor.translators.TranslatorFactory;


import java.math.BigDecimal;

public class ConversionExec {

    private SubsDetector subsDetector;
    private BigDecimal fromFramerate;
    private BigDecimal toFramerate;
    private SubtitleType subType;
    private Language languageFrom;
    private Language languageInto;

    public ConversionExec() {
        subsDetector = new SubsDetector();
    }

    public StringBuilder convert(byte[] sub) throws Exception {

        //detect the file type
        SubtitleType subTypeDetected = subsDetector.detectSubtitleType(sub);
        Converter conv = ConvertorFactory.create(subTypeDetected);

        BigDecimal ratio = new BigDecimal(1);
        if (!toFramerate.equals(fromFramerate)) {
            ratio = fromFramerate.divide(toFramerate, 10, BigDecimal.ROUND_UP);
        }

        StringBuilder sb = conv.createNewConvertedSubtitle(sub, ratio);

        if (languageFrom != null && languageInto != null) {
            SubtitleTranslator trans = TranslatorFactory.create(subTypeDetected);
            trans.setOriginalLanguage(languageFrom);
            trans.setDestinationLanguage(languageInto);
            sb = trans.translate(sb);
        }

        if (subType != null && subTypeDetected != subType) {
            SubtitleTypeConverter typeConv = SubtitleTypeConverterFactory.create(subTypeDetected, subType);
            sb = typeConv.convert(sb, toFramerate.intValue());
        }

        return sb;
    }

    public void setSubtitleType(SubtitleType subType) {
        this.subType = subType;
    }

    public BigDecimal getFromFramerate() {
        return fromFramerate;
    }

    public void setFromFramerate(BigDecimal fromFramerate) {
        this.fromFramerate = fromFramerate;
    }

    public BigDecimal getToFramerate() {
        return toFramerate;
    }

    public void setToFramerate(BigDecimal toFramerate) {
        this.toFramerate = toFramerate;
    }

    public Language getLanguageFrom() {
        return languageFrom;
    }

    public void setLanguageFrom(Language languageFrom) {
        this.languageFrom = languageFrom;
    }

    public Language getLanguageInto() {
        return languageInto;
    }

    public void setLanguageInto(Language languageInto) {
        this.languageInto = languageInto;
    }
}
