package com.subsconvertor;

import com.subsconvertor.converters.Converter;
import com.subsconvertor.converters.ConvertorFactory;
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

    public ConversionExec() {
        subsDetector = new SubsDetector();
    }

    public void convert(String subtitle) {

        //detect the file
//        File sub = new File("resources\\files\\original\\" + subtitle);
        File sub = new File(ConversionExec.class.getClass().getResource(Globals.PATH_UPLOAD_ORIGINAL_SUBTITLES
                +subtitle).getPath());

//        System.out.println(sub.getAbsolutePath());

        SubtitleType subType = subsDetector.detectSubtitleType(sub);
        Converter conv = ConvertorFactory.create(subType);
        BigDecimal ratio = fromFramerate.divide(toFramerate);

        StringBuilder sb = conv.createNewConvertedSubtitle(sub, ratio);
        saveNewConvertedFile(sb, sub);
    }

    void saveNewConvertedFile(StringBuilder sb, File sub) {
        try {
            // Create file
//            FileWriter fstreamWrite = new FileWriter("files\\converted\\" +
//                    FileUtils.getFileName(sub.getName()) + "_converted" +
//                    FileUtils.getFileExtension(sub.getName()));
//            System.out.println(ConversionExec.class.getClass().getResource("/files/converted/").getPath() +
//                    FileUtils.getFileName(sub.getName()) + "_converted" +
//                    FileUtils.getFileExtension(sub.getName()));
            FileWriter fstreamWrite = new FileWriter(
                    ConversionExec.class.getClass().getResource(Globals.PATH_CONVERTED_SUBTITLES).getPath() +
                    FileUtils.getFileName(sub.getName()) + "_converted" +
                    FileUtils.getFileExtension(sub.getName()));

            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(sb.toString());
            //Close the output stream
            out.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

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
