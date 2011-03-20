package com.subsconvertor;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;
import com.subsconvertor.detector.SubsDetectorTest;
import com.subsconvertor.utils.FileUtils;
import com.subsconvertor.utils.UnicodeBOMInputStream;
import junit.framework.TestCase;
import org.apache.commons.io.IOUtils;
import sun.nio.cs.UnicodeEncoder;

import java.io.*;

/**
 *
 */
public class FilesHelperTest extends TestCase {

    //sub file paths
    public static final String PATH_UPLOAD_ORIGINAL_SUBTITLES = "/files/original/";
    public static final String PATH_CONVERTED_SUBTITLES = "/files/converted/";

    public String getEncoding(String filename) throws Exception{
        File f = new File(
                SubsDetectorTest.class.getResource(PATH_UPLOAD_ORIGINAL_SUBTITLES).getPath()
                        + filename);
        FileInputStream fstream = new FileInputStream(f);
        BufferedInputStream dst = new BufferedInputStream(fstream);
        return FileUtils.detectEncoding(dst);
    }

    public byte[] getByteArrayFromFile(String filename, String encoding) throws Exception {
        File f = new File(
                SubsDetectorTest.class.getResource(PATH_UPLOAD_ORIGINAL_SUBTITLES).getPath()
                        + filename);
        FileInputStream fstream = new FileInputStream(f);
        BufferedInputStream dst = new BufferedInputStream(fstream);



        if (encoding.contains("UTF-8")) {
            return FileUtils.getByteArrayWithoutBOM(dst);
        } else {
            InputStreamReader in = new InputStreamReader(dst, encoding);

            byte[] b = IOUtils.toByteArray(in);

            return b;
        }
    }

    public void saveNewConvertedFile(StringBuilder sb, String filename, String encoding) {
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Thread.currentThread().getClass().getResource(PATH_CONVERTED_SUBTITLES).getPath() + filename), encoding));

            out.write(sb.toString());
            //Close the output stream
            out.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
