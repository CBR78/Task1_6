package ua.com.foxminded.malzam.anagram;

import java.util.StringJoiner;

public class Anagram {

    public String reverseText(String text) {
        if (text == null) {
            throw new IllegalArgumentException("text is illegal argument null");
        }
        if (text.length() == 0) {
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
            char charI = word.charAt(i);
            char charJ = word.charAt(j);
            if (Character.isLetter(charI) && Character.isLetter(charJ)) {
                reversedWord[i] = charJ;
                reversedWord[j] = charI;
                i++;
                j--;
            } else {
                if (!Character.isLetter(charI)) {
                    i++;
                }
                if (!Character.isLetter(charJ)) {
                    j--;
                }
            }
        }
        return new String(reversedWord);
    }
}