package com.subsconvertor;

import com.subsconvertor.converters.Converter;
import com.subsconvertor.converters.ConvertorFactory;
import com.subsconvertor.converters.type.SubtitleTypeConverter;
import com.subsconvertor.converters.type.SubtitleTypeConverterFactory;
import com.subsconvertor.detector.SubsDetector;
import com.subsconvertor.detector.SubtitleType;
import com.subsconvertor.utils.FileUtils;
import com.subsconvertor.utils.Globals;

import java.io.*;
import java.math.BigDecimal;

public class ConversionExec {

    private SubsDetector subsDetector;
    private BigDecimal fromFramerate;
    private BigDecimal toFramerate;
    private SubtitleType subType;

    public ConversionExec() {
        subsDetector = new SubsDetector();
    }

    public StringBuilder convert(byte[] sub) {

        //detect the file type
        SubtitleType subTypeDetected = subsDetector.detectSubtitleType(sub);
        Converter conv = ConvertorFactory.create(subTypeDetected);
        BigDecimal ratio = fromFramerate.divide(toFramerate);

        StringBuilder sb = conv.createNewConvertedSubtitle(sub, ratio);

        //inca nu e vremea pentru asa ceva
//        if (subTypeDetected != subType) {
//            SubtitleTypeConverter typeConv = SubtitleTypeConverterFactory.create(subTypeDetected, subType);
//            sb = typeConv.convert(sb);
//        }

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
}
