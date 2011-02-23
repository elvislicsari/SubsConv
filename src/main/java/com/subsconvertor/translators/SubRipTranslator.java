package com.subsconvertor.translators;

import com.google.api.translate.Translator;
import com.subsconvertor.model.SubRipGoogleKey;
import com.subsconvertor.utils.Globals;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
class SubRipTranslator extends AbstractSubtitleTranslator {

    /**
     * This method translates the subtitle line by line. It can be easily overwritten in the children classes
     * to implement a translation for every type of subtitle.
     *
     * @param sb
     * @return StringBuilder
     */
    public StringBuilder translate(StringBuilder sb) throws Exception {

        Translator.setHttpReferrer("www.subsynch.com");
        Scanner sc = new Scanner(sb.toString()).useDelimiter(Globals.newline);
        String subLine = "";
        int charsCounter = 0;
        int lineCounter = 0;

        List<Map<SubRipGoogleKey, String>> allContentList = new ArrayList<Map<SubRipGoogleKey, String>>();
        Map<SubRipGoogleKey, String> googleChunkSizeList = new TreeMap<SubRipGoogleKey, String>();
        //1. first, we extract the tet from the subtitle file in such a way that it would be easier for us
        //to translate it and put the translated text replacing the old text
        SubRipGoogleKey key = new SubRipGoogleKey();
        boolean nextLineIsText = false;
        while (sc.hasNext()) {
            subLine = sc.next();

//            System.out.println(subLine);

            if (charsCounter >= Globals.googleTranslatorCharsLimit) {
                allContentList.add(googleChunkSizeList);
                googleChunkSizeList = new TreeMap<SubRipGoogleKey, String>();
                charsCounter = 0;
                lineCounter = 0;
            }

            //last line
            if (subLine.equals(Globals.newline) || subLine.equals("")) {
//                System.out.println("is 4th line");
                nextLineIsText = false;
                key = new SubRipGoogleKey();
            }

            if (nextLineIsText) {
//                System.out.println("is text");
//                System.out.println(key);
//                System.out.println("????"+googleChunkSizeList.containsKey(key));
                if (googleChunkSizeList.containsKey(key)) {
                    googleChunkSizeList.put(key, googleChunkSizeList.get(key) + Globals.linesSeparator + subLine);
                    charsCounter += subLine.length() + Globals.linesSeparator.length();
                } else {
//                    System.out.println("line counter="+lineCounter);
                    key.setLineCounter(lineCounter);
                    googleChunkSizeList.put(key, subLine);
                    charsCounter += subLine.length();
                    lineCounter++;
                }
            }

            //first line
            Pattern pattern = Pattern.compile(Globals.SubRip_PATTERN_FIRST_LINE);
            Matcher matcher = pattern.matcher(subLine);
            if (matcher.find()) {
                key.setPackageNumber(Integer.parseInt(subLine));
//                System.out.println("is first line");
            }

            //second line
            pattern = Pattern.compile(Globals.SubRip_PATTERN_TIME_LINE);
            matcher = pattern.matcher(subLine);
            if (matcher.find()) {
                key.setTimeLine(subLine);
//                System.out.println("is second line");
                nextLineIsText = true;
            }
//            System.out.println("next line is text: "+nextLineIsText);
        }
        allContentList.add(googleChunkSizeList);

//        System.out.println(allContentList);
//        System.out.println(allContentList.size());

        //2. we have now the list with the content of the subtitle file
        //we have to convert from this list into arrays
        for (Map<SubRipGoogleKey, String> chunk : allContentList) {
            String[] input = (String[]) chunk.values().toArray(new String[0]);
//            System.out.println("----------");
//            System.out.println(Arrays.toString(input));
            String[] result = Translator.execute(input, getOriginalLanguage(), getDestinationLanguage());
//            System.out.println(Arrays.toString(result));
//            System.out.println("----------");

            for (int i = 0; i < result.length; i++) {
                for (Map.Entry<SubRipGoogleKey, String> entry : chunk.entrySet()) {
                    if (entry.getKey().getLineCounter() == i) {
                        entry.setValue(result[i]);
                    }
                }
            }
        }

//        System.out.println(allContentList);

        StringBuilder sbNew = new StringBuilder();
        //right here
        for (Map<SubRipGoogleKey, String> chunk : allContentList) {
            for (Map.Entry<SubRipGoogleKey, String> entry : chunk.entrySet()) {
                sbNew.append(entry.getKey().getPackageNumber()+Globals.newline);
                sbNew.append(entry.getKey().getTimeLine()+Globals.newline);
                sbNew.append(entry.getValue().replaceAll(" \\"+Globals.linesSeparator+" ", Globals.newline)+Globals.newline);
                sbNew.append(Globals.newline);
            }
        }

        return sbNew;
    }
}
