package ua.com.foxminded.malzam.anagram;

import java.util.StringJoiner;

public class Anagram {

    public String reverseText(String text) {
        if (text == null) {
            throw new IllegalArgumentException("text is illegal argument null");
        }
        if (text.isEmpty()) {
            throw new IllegalArgumentException("text is empty");
        }
        StringJoiner joiner = new StringJoiner(" ");
        for (String word : text.split(" ")) {
            joiner.add(reverseLetters(word));
        }
        return joiner.toString();
    }

    private String reverseLetters(String word) {
        char[] endChar = word.toCharArray();
        for (int i = 0, j = word.length() - 1; i < j;) {
            char startCharI = word.charAt(i);
            char startCharJ = word.charAt(j);
            if (Character.isLetter(startCharI) && Character.isLetter(startCharJ)) {
                endChar[i] = startCharJ;
                endChar[j] = startCharI;
                i++;
                j--;
            } else {
                if (!Character.isLetter(startCharI)) {
                    i++;
                }
                if (!Character.isLetter(startCharJ)) {
                    j--;
                }
            }
        }
        return new String(endChar);
    }
}