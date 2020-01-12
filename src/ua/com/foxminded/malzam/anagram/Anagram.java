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
            boolean iIsLetter = Character.isLetter(word.charAt(i));
            boolean jIsLetter = Character.isLetter(word.charAt(j));
            if (iIsLetter == true && jIsLetter == true) {
                reversedWord[i] = word.charAt(j);
                reversedWord[j] = word.charAt(i);
                i++;
                j--;
            } else {
                if (iIsLetter == false && jIsLetter == false) {
                    i++;
                    j--;
                } else {
                    if (iIsLetter) {
                        j--;
                    }
                    if (jIsLetter) {
                        i++;
                    }
                }
            }
        }
        return new String(reversedWord);
    }
}