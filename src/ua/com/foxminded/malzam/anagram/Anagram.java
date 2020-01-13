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
        char[] reversedWord = word.toCharArray();
        for (int i = 0, j = word.length() - 1; i < j;) {
            char startChar = word.charAt(i);
            char endChar = word.charAt(j);
            if (Character.isLetter(startChar) && Character.isLetter(endChar)) {
                reversedWord[i] = endChar;
                reversedWord[j] = startChar;
                i++;
                j--;
            } else {
                if (!Character.isLetter(startChar)) {
                    i++;
                }
                if (!Character.isLetter(endChar)) {
                    j--;
                }
            }
        }
        return new String(reversedWord);
    }
}