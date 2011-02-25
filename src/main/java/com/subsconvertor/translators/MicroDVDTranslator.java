package com.subsconvertor.translators;

import com.google.api.translate.Language;
import com.google.api.translate.Translator;
import com.subsconvertor.model.MultiDVDGoogleKey;
import com.subsconvertor.utils.Globals;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
final class MicroDVDTranslator extends AbstractSubtitleTranslator {

    public StringBuilder translate(StringBuilder sb) throws Exception {

        Translator.setHttpReferrer("www.subsynch.com");
        Scanner sc = new Scanner(sb.toString()).useDelimiter(Globals.newline);
        String subLine = "";
        int lineNumber = 0;
        int charsCounter = 0;

        List<Map<MultiDVDGoogleKey, String>> allContentList = new ArrayList<Map<MultiDVDGoogleKey, String>>();
        Map<MultiDVDGoogleKey, String> googleChunkSizeList = new TreeMap<MultiDVDGoogleKey, String>();
        //1. first, we extract the tet from the subtitle file in such a way that it would be easier for us
        //to translate it and put the translated text replacing the old text
        while (sc.hasNext()) {
            subLine = sc.next();
            MultiDVDGoogleKey key = new MultiDVDGoogleKey();

            Pattern pattern = Pattern.compile(Globals.MicroDVD_PATTERN_ENTIRE_LINE);
            Matcher matcher = pattern.matcher(subLine);
            matcher.find();
            key.setFramerates("{" + matcher.group(1) + "}{" + matcher.group(2) + "}");

            if (charsCounter >= Globals.googleTranslatorCharsLimit) {
                allContentList.add(googleChunkSizeList);
                googleChunkSizeList = new TreeMap<MultiDVDGoogleKey, String>();
                charsCounter = 0;
                lineNumber = 0;
            }
            key.setLineNumber(lineNumber);

            googleChunkSizeList.put(key, matcher.group(3));

            charsCounter += subLine.length();
            lineNumber++;
            //last line

        }
        allContentList.add(googleChunkSizeList);

//        System.out.println(allContentList);
//

//        System.out.println(allContentList.size());

        //2. we have now the list with the content of the subtitle file
        //we have to convert from this list into arrays
        for (Map<MultiDVDGoogleKey, String> chunk : allContentList) {
            String[] input = (String[]) chunk.values().toArray(new String[0]);
//            System.out.println("----------");
//            System.out.println(Arrays.toString(input));
            String[] result = Translator.execute(input, getOriginalLanguage(), getDestinationLanguage());
//            System.out.println(Arrays.toString(result));
//            System.out.println("----------");

            for (int i = 0; i < result.length; i++) {
                for (Map.Entry<MultiDVDGoogleKey, String> entry : chunk.entrySet()) {
                    if (entry.getKey().getLineNumber() == i) {
                        entry.setValue(result[i]);
                    }
                }
            }
        }
//
//        System.out.println(allContentList);
//        System.exit(0);

        StringBuilder sbNew = new StringBuilder();
//        //right here
        for (Map<MultiDVDGoogleKey, String> chunk : allContentList) {
            for (Map.Entry<MultiDVDGoogleKey, String> entry : chunk.entrySet()) {
                sbNew.append(entry.getKey().getFramerates());
                sbNew.append(entry.getValue() + Globals.newline);
            }
        }

        return sbNew;
    }
}
