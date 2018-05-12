package com.karbyshev;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        String first = "with its powerful tools and dazzling effects,Keynote makes it Easy to create stunning and memorable presentations. ";
        String second = "See Who you 're working with ... While you ' re editing, a separate list lets you quickly see who else is in the presentation.";
        System.out.println(first);
        editText(first);

        System.out.println("--------------------------------------------------");

        System.out.println(second);
        editText(second);
    }

    private static void editText(String textToEdit){
        textToEdit = deleteSpaceBeforeApostrophe(textToEdit);
        textToEdit = toUpperCaseFirstSymbol(textToEdit);
        StringBuilder sb = new StringBuilder();
        StringTokenizer s = new StringTokenizer(textToEdit,",;:.", true);
        while (s.hasMoreTokens()){
            String temp = s.nextToken();
            temp = temp.trim();
            if (!temp.equals(";")
                    && !temp.equals(",")
                    && !temp.equals(".")
                    && !temp.equals(":")
                    && s.hasMoreTokens()) {
                sb.append(" " + temp);
            } else {
                sb.append(temp);
            }
        }

        String outputText = sb.toString().trim();
        System.out.println(outputText);
    }

    private static String deleteSpaceBeforeApostrophe(String textWithSpaceBeforeApostrophe){
        StringBuilder sb = new StringBuilder();
        StringTokenizer deleteSpaceBeforeApostrophe = new StringTokenizer(textWithSpaceBeforeApostrophe,"\'", true);
        while (deleteSpaceBeforeApostrophe.hasMoreTokens()){
            String temp = deleteSpaceBeforeApostrophe.nextToken();
            temp = temp.trim();
            sb.append(temp);
        }
        String readyToNextEdit = sb.toString();
        return readyToNextEdit;
    }

    private static String toUpperCaseFirstSymbol(String allText){
        StringBuilder sb = new StringBuilder();
        StringTokenizer deleteSpaceBeforeApostrophe = new StringTokenizer(allText,".", true);
        while (deleteSpaceBeforeApostrophe.hasMoreTokens()){
            String temp = deleteSpaceBeforeApostrophe.nextToken();
            temp = temp.toLowerCase();
            temp = temp.trim();
            temp = String.valueOf(temp.charAt(0)).toUpperCase() + temp.substring(1);
            sb.append(temp);
        }
        String readyToNextEdit = sb.toString();
        return readyToNextEdit;
    }
}
