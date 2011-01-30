package com.subsconvertor;

import com.subsconvertor.detector.SubsDetectorTest;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.*;

/**
 *
 */
public class FilesHelperTest extends TestCase {

    //sub file paths
    public static final String PATH_UPLOAD_ORIGINAL_SUBTITLES = "/files/original/";
    public static final String PATH_CONVERTED_SUBTITLES = "/files/converted/";

    public byte[] getByteArrayFromFile(String filename) throws Exception {
        File f = new File(
                SubsDetectorTest.class.getResource(PATH_UPLOAD_ORIGINAL_SUBTITLES).getPath()
                        + filename);
        FileInputStream fstream = new FileInputStream(f);
        DataInputStream in = new DataInputStream(fstream);
        byte[] b = new byte[in.available()];
        in.read(b);

        return b;
    }

    public void saveNewConvertedFile(StringBuilder sb, String filename) {
        try {
            FileWriter fstreamWrite = new FileWriter(
                    Thread.currentThread().getClass().getResource(PATH_CONVERTED_SUBTITLES).getPath() + filename);

            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(sb.toString());
            //Close the output stream
            out.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testAll() {

    }
}
