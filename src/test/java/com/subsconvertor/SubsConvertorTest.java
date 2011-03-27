package com.subsconvertor;

import com.google.api.translate.Language;
import com.google.api.translate.Translator;
import com.subsconvertor.detector.SubsDetector;
import com.subsconvertor.model.SubtitleType;
import com.subsconvertor.utils.FileUtils;

import java.io.PrintStream;
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

        ConversionExec conv = new ConversionExec(new SubsDetector());
        conv.setFromFramerate(new BigDecimal(23.976));
        conv.setToFramerate(new BigDecimal(25));
//        conv.setSubtitleType(SubtitleType.SubRip);
//        conv.setLanguageFrom(Language.ENGLISH);
//        conv.setLanguageInto(Language.GERMAN);
        String subtitleName = "test_utf8_chars.sub";
        String encoding = getEncoding(subtitleName);
        System.out.println(encoding);
        byte[] b = getByteArrayFromFile(subtitleName, encoding);
        StringBuilder sb = conv.convert(b, encoding);
//        System.out.println(sb);
//        System.exit(0);
        saveNewConvertedFile(sb, FileUtils.getFileName(subtitleName)+"_subsynched"+FileUtils.getFileExtension(subtitleName), encoding);
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
