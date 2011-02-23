package com.subsconvertor;

import com.google.api.translate.Language;
import com.google.api.translate.Translator;
import com.subsconvertor.detector.SubsDetector;
import com.subsconvertor.model.SubtitleType;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 */
public class SubsConvertorTest extends FilesHelperTest {
    @org.junit.Test
    public void testConversion() throws Exception {

//        System.out.println(Arrays.toString(Language.values()));
//        System.out.println(Language.valueOf("ENGLISH").name());
//        System.out.println(Language.valueOf("ENGLISH"));
//        System.out.println(Language.valueOf(Language.valueOf("en").name()));
//
//        Language[] languages = Language.values();
//        System.out.println(languages[4].name());

//        ConversionExec conv = new ConversionExec(new SubsDetector());
//        conv.setFromFramerate(new BigDecimal(0));
//        conv.setToFramerate(new BigDecimal(0));
//        conv.setLanguageFrom(Language.ENGLISH);
//        conv.setLanguageInto(Language.ROMANIAN);
//        byte[] b = getByteArrayFromFile("respiro.sub");
//        StringBuilder sb = conv.convert(b);
//        saveNewConvertedFile(sb, "respiro_conv.srt");
//
//        byte[] b = getByteArrayFromFile("SinNombre.srt");
//        StringBuilder sb = conv.convert(b);
//        saveNewConvertedFile(sb, "subsynched.srt");


//        conv.setSubtitleContentType(SubtitleType.SubRip);
//        byte[] b = getByteArrayFromFile("Black.Swan.2010.720p.WEBSCR.XviD.AC3-TiMPE.sub");
//        StringBuilder sb = conv.convert(b);
//        saveNewConvertedFile(sb, "subsynch_converted.srt");


//        conv.setSubtitleContentType(SubtitleType.MicroDVD);
//        byte[] b = getByteArrayFromFile("Black.Swan.2010.720p.WEBSCR.XviD.AC3-TiMPE.srt");
//        StringBuilder sb = conv.convert(b);
//        saveNewConvertedFile(sb, "Black.Swan.2010.720p.WEBSCR.XviD.AC3-TiMPE.sub");


    }
}
