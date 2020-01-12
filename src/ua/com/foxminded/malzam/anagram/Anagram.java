package ua.com.foxminded.malzam.anagram;

import java.util.StringJoiner;

public class Anagram {

    public String reverseText(String text) {
        StringJoiner joiner = new StringJoiner(" ");
        for (String word : text.split(" ")) {
            joiner.add(reverseLetters(word));
        }
        return joiner.toString();
    }

    private String reverseLetters(String word) {
        char[] reversedWord = word.toCharArray();
        for (int i = 0, j = word.length() - 1; i < j;) {
            if (Character.isLetter(word.charAt(i)) && Character.isLetter(word.charAt(j))) {
                reversedWord[i] = word.charAt(j);
                reversedWord[j] = word.charAt(i);
                i++;
                j--;
            } else {
                if (!Character.isLetter(word.charAt(i))) {
                    i++;
                }
                if (!Character.isLetter(word.charAt(j))) {
                    j--;
                }
            }
        }
        return new String(reversedWord);
    }
}