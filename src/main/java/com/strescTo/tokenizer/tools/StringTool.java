package com.strescTo.tokenizer.tools;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTool {

   private static String abberiviations = "";

    private static String stopWords = "";

    private static Pattern endCharPattern = Pattern.compile("\\?$|!$|\\.$");


    public static String cleanWord(String word)
    {
        String cleaned = word.trim();
        cleaned.replaceAll("\\.|!|\\?|,","");
        return cleaned;
    }

    public static boolean isAbberivation(String word){
        String cleaned = cleanWord(word);
        Pattern p = Pattern.compile(cleaned);
        Matcher m = p.matcher(abberiviations);
        return m.matches();
    }

    public static String endCharacter(String word)
    {
        String cleaned = word.trim();
        Matcher m = endCharPattern.matcher(cleaned);
        if(m.matches()) {
            return word.substring(word.length() - 1);
        } else{
        return null;}
    }

    public static boolean haveEndChar(String word)
    {
        String cleaned = word.trim();
        Matcher m = endCharPattern.matcher(cleaned);
        return m.find();
    }

    public static boolean isStopWord(String word)
    {
        String cleaned = word.trim();
        Matcher m = endCharPattern.matcher(cleaned);
        return m.matches();
    }

}
